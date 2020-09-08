package elementalalchemie.tileentitys;

import java.util.Optional;

import elementalalchemie.InventoryUtil;
import elementalalchemie.blocks.JuiceExtractorBlock;
import elementalalchemie.init.TileEntityTypeInit;
import elementalalchemie.recipes.ExtractJuiceRecipe;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraftforge.items.ItemStackHandler;

public class JuiceExtractorTileEntity extends TileEntity implements ITickableTileEntity {

	public static final int NEEDED_STAMPS = 6;
	public static final int MAX_FILL_BUCKET_RENDER_TICKS = 50;
	private int fillBucketRenderTicks;

	private int currentStamps;
	
	private ItemStack bucket;

	private ItemStackHandler inv = new ItemStackHandler(JuiceExtractorBlock.MAX_INGRIEDIENTS);

	public JuiceExtractorTileEntity() {
		super(TileEntityTypeInit.JUICE_EXTRACTOR_TE.get());

	}

	@Override
	public void read(CompoundNBT compound) {

		bucket = ItemStack.read(compound.getCompound("bucket"));

		int size = compound.getInt("size");
		NonNullList<ItemStack> items = NonNullList.withSize(size, ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound.getCompound("items"), items);
		
		for (int i = 0; i < size; i++) {

			inv.setStackInSlot(i, items.get(i));
		}
		this.currentStamps = compound.getInt("stamps");
		super.read(compound);
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {

		CompoundNBT nbt = new CompoundNBT();

		if (bucket != null) {

			bucket.write(nbt);

			compound.put("bucket", nbt);
		}
		compound.putInt("size", inv.getSlots());

		nbt = new CompoundNBT();
		NonNullList<ItemStack> items = NonNullList.withSize(inv.getSlots(), ItemStack.EMPTY);
		for (int i = 0; i < inv.getSlots(); i++) {
			if (inv.getStackInSlot(i) != null && !inv.getStackInSlot(i).isEmpty())
				items.set(i, inv.getStackInSlot(i));
		}
		ItemStackHelper.saveAllItems(nbt, items);

		compound.put("items", nbt);

		compound.putInt("stamps", currentStamps);

		return super.write(compound);
	}

	public ItemStack removeBucket() {
		if (bucket == null)
			return ItemStack.EMPTY;
		ItemStack s = bucket.copy();
		bucket = ItemStack.EMPTY;
		return s;
	}

	public ItemStack getBucket() {
		if (bucket == null)
			return ItemStack.EMPTY;
		return bucket;
	}

	public void setBucket(ItemStack bucket) {
		this.bucket = bucket;
	}

	public ItemStack removeIngriedient(ItemStack stack) {

		ItemStack ingriedient = InventoryUtil.containsItem(inv, stack) ? stack.copy() : null;

		if (ingriedient == null)
			return ItemStack.EMPTY;
		ItemStack s = ingriedient.copy();

		InventoryUtil.extractFirstOccurenceOf(inv, s);
		return s;
	}

	public ItemStackHandler getInv() {
		return inv;
	}

	@Override
	public CompoundNBT getUpdateTag() {

		return write(super.getUpdateTag());
	}

	@Override
	public void handleUpdateTag(CompoundNBT tag) {

		read(tag);
		super.handleUpdateTag(tag);
	}

	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {

		return new SUpdateTileEntityPacket(this.pos, 1, this.write(new CompoundNBT()));
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {

		read(pkt.getNbtCompound());

		super.onDataPacket(net, pkt);
	}

	public void onStamp() {

		if (!world.isRemote) {
			
			Optional<ExtractJuiceRecipe> optional = world.getServer().getRecipeManager()
					.getRecipe(ExtractJuiceRecipe.EXTRACT_JUICE, InventoryUtil.parse(getInv()), world);

			if (optional.isPresent()&&currentStamps<NEEDED_STAMPS) {

				currentStamps++;
				world.notifyBlockUpdate(getPos(), getBlockState(), getBlockState(), 2);
			}
		}
	}

	@Override
	public void tick() {

		if (!world.isRemote) {

			Optional<ExtractJuiceRecipe> optional = world.getServer().getRecipeManager()
					.getRecipe(ExtractJuiceRecipe.EXTRACT_JUICE, InventoryUtil.parse(getInv()), world);

			if (optional.isPresent()&&currentStamps>=NEEDED_STAMPS&&bucket!=null&&!bucket.isEmpty()) {
				
				if(fillBucketRenderTicks<MAX_FILL_BUCKET_RENDER_TICKS)
					fillBucketRenderTicks++;
				else {
					
					currentStamps=0;
					fillBucketRenderTicks=0;
					ExtractJuiceRecipe extractjuicerecipe = optional.get();
					setBucket(extractjuicerecipe.getCraftingResult(InventoryUtil.parse(getInv())));
					inv = new ItemStackHandler(JuiceExtractorBlock.MAX_INGRIEDIENTS);
					world.notifyBlockUpdate(getPos(), getBlockState(), getBlockState(), 2);
				}
			}
		}else if(currentStamps>=NEEDED_STAMPS&&bucket!=null&&!bucket.isEmpty()) {
			
			if(fillBucketRenderTicks<MAX_FILL_BUCKET_RENDER_TICKS)
				fillBucketRenderTicks++;
			
		}else fillBucketRenderTicks=0;
	}
	
	public int getFillBucketRenderTicks() {
		return fillBucketRenderTicks;
	}
	
	public int getCurrentStamps() {
		return currentStamps;
	}

	public void setCurrentStamps(int currentStamps) {
		this.currentStamps = currentStamps;
	}

}
