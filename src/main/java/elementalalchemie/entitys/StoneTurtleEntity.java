package elementalalchemie.entitys;

import java.util.ArrayList;
import java.util.Random;

import elementalalchemie.client.model.entity.MoveIntoDarknessGoal;
import elementalalchemie.init.ItemInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class StoneTurtleEntity extends CreatureEntity {

	private static final DataParameter<Boolean> SHEARED = EntityDataManager.createKey(StoneTurtleEntity.class,
			DataSerializers.BOOLEAN);

	private static final DataParameter<Integer> CRYSTAL_TIMER = EntityDataManager.createKey(StoneTurtleEntity.class,
			DataSerializers.VARINT);

	public static final int CRYSTAL_GROWTH_TIME = 800;

	public StoneTurtleEntity(EntityType<? extends StoneTurtleEntity> type, World p_i48577_2_) {
		super(type, p_i48577_2_);
	}

	@Override
	public void livingTick() {

		if (!world.isRemote && isSheared())
			dataManager.set(CRYSTAL_TIMER, dataManager.get(CRYSTAL_TIMER) + 1);
		if (dataManager.get(CRYSTAL_TIMER) > CRYSTAL_GROWTH_TIME) {
			setSheared(false);
			dataManager.set(CRYSTAL_TIMER, 0);
		}
		super.livingTick();
	}

	@Override
	protected void registerGoals() {

		this.goalSelector.addGoal(1, new SwimGoal(this));

		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true) {
			@Override
			public double getAttackReachSqr(LivingEntity attackTarget) {

				return Math.pow(this.attacker.getWidth(), 2) + attackTarget.getWidth();
			}
		});
		this.goalSelector.addGoal(4, new MoveTowardsTargetGoal(this, 0.9D, 32.0F));

		this.goalSelector.addGoal(5, new TemptGoal(this, 1.25D, Ingredient.fromItems(Items.STONE), false));

		int retreatRange = 16;
		this.goalSelector.addGoal(6, new MoveIntoDarknessGoal(this, 1.0D, retreatRange) );

		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 6.0F));

		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));

	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("Sheared", this.isSheared());
		compound.putInt("timer", getCrystalGrowthTimer());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setSheared(compound.getBoolean("Sheared"));
		dataManager.set(CRYSTAL_TIMER, compound.getInt("timer"));
	}

	@Override
	public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {

		return true;
	}

	@Override
	protected ResourceLocation getLootTable() {
		return super.getLootTable();
	}

	public static boolean shouldSpawn(EntityType<StoneTurtleEntity> entity, IWorld world, SpawnReason spawnReason,
			BlockPos pos, Random random) {

		if (world.getDimension().getType().getId() != 0)
			return false;

		if (pos.getY() >= world.getSeaLevel()) {
			return false;
		} else {
			int i = world.getLight(pos);
			int j = 4;

			boolean b = i > random.nextInt(j) ? false : func_223315_a(entity, world, spawnReason, pos, random);

			if (b)
				System.out.println("Spanwed at:" + pos);

			return b;
		}
	}

	public boolean processInteract(PlayerEntity player, Hand hand) {

		// Does not use IShearable cause we want a pickaxe instead of a shear
		ItemStack itemstack = player.getHeldItem(hand);
		if (itemstack.getItem().getToolTypes(itemstack).contains(ToolType.PICKAXE) && !isSheared()) {
			this.shear();
			if (!this.world.isRemote) {

				itemstack.damageItem(1, player, (p_213613_1_) -> {
					p_213613_1_.sendBreakAnimation(hand);
				});
			}
		}

		return super.processInteract(player, hand);
	}

	private void shear() {

		if (!this.world.isRemote) {
			this.setSheared(true);
			int i = 1 + this.rand.nextInt(3);

			for (int j = 0; j < i; ++j) {
				InventoryHelper.spawnItemStack(this.world, this.posX, this.posY, this.posZ,
						new ItemStack(ItemInit.STONE_TURTLE_CRYSTAL.get()));
			}
		}

		this.playSound(SoundEvents.ENTITY_SHEEP_SHEAR, 1.0F, 1.0F);
	}

	@Override
	protected void registerData() {

		this.dataManager.register(SHEARED, false);
		this.dataManager.register(CRYSTAL_TIMER, 0);

		super.registerData();
	}

	@Override
	protected int decreaseAirSupply(int air) {

		return air;
	}

	@Override
	public float getBlockPathWeight(BlockPos pos, IWorldReader worldIn) {

		if (worldIn.getFluidState(pos) != Fluids.EMPTY)
			return -10;

		return 0.5F - worldIn.getBrightness(pos)
				+ (worldIn.getBlockState(pos).getBlock() == Blocks.STONE ? 0.5f : 0.0f);
	}

	protected void registerAttributes() {
		super.registerAttributes();

		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.1D);
		this.getAttribute(SWIM_SPEED).setBaseValue(2.55D);
	}

	@Override
	public Iterable<ItemStack> getArmorInventoryList() {

		return new ArrayList<ItemStack>();
	}

	@Override
	public ItemStack getItemStackFromSlot(EquipmentSlotType slotIn) {

		return ItemStack.EMPTY;
	}

	@Override
	public void setItemStackToSlot(EquipmentSlotType slotIn, ItemStack stack) {

	}

	@Override
	public HandSide getPrimaryHand() {

		return HandSide.RIGHT;
	}

	public boolean isSheared() {
		return this.dataManager.get(SHEARED);
	}

	public void setSheared(boolean b) {
		this.dataManager.set(SHEARED, b);
	}

	public int getCrystalGrowthTimer() {
		return dataManager.get(CRYSTAL_TIMER);
	}

}
