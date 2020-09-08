package elementalalchemie.tileentitys;

import elementalalchemie.blocks.BanQuadPartBlock;
import elementalalchemie.blocks.PrimitivKeitwFluidEvaporator;
import elementalalchemie.capablilitys.DefaultElementalEnergieStorage;
import elementalalchemie.capablilitys.IElementalBeeingCapability;
import elementalalchemie.capablilitys.IElementalEnergyCapability;
import elementalalchemie.fluids.Keitw_Fluid;
import elementalalchemie.init.BlockInit;
import elementalalchemie.init.CapabilityInit;
import elementalalchemie.init.TileEntityTypeInit;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class PrimitvKeitwFluidEvaporatorTileEntity extends TileEntity implements ITickableTileEntity {

	private static final Capability<IFluidHandler> FLUID_CAPABILITY = CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY;

	private FluidTank fluidTank;

	private static final Capability<IItemHandler> ITEM_CAPABILITY = CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;

	private IItemHandler inventory;

	private static final Capability<IElementalEnergyCapability> ELEMENTAL_ENERGY = CapabilityInit.ELEMENTAL_ENERGY;

	private IElementalEnergyCapability energyStorage;

	private int burnTime;

	private int gasAmount;

	public static final int MAX_GAS_AMOUNT = 1000;

	public static final int MIN_GAS_AMOUNT = 800;

	public PrimitvKeitwFluidEvaporatorTileEntity() {

		super(TileEntityTypeInit.PRIMITV_EVAPORATOR_TE.get());

		burnTime = 0;

		inventory = new ItemStackHandler(1) {

			@Override
			protected void onContentsChanged(int slot) {
				markDirty();
				super.onContentsChanged(slot);
			}

			@Override
			public boolean isItemValid(int slot, ItemStack stack) {

				return net.minecraftforge.common.ForgeHooks.getBurnTime(stack) > 0;
			}
		};

		energyStorage = new DefaultElementalEnergieStorage(1000);

		fluidTank = new FluidTank(MAX_GAS_AMOUNT, PrimitvKeitwFluidEvaporatorTileEntity::isFluidValid);
	}
	
	private static int tick=0;
	private boolean banQuadIntact;
	@Override
	public void tick() {

		if (world.isRemote() || world.getBlockState(pos).get(PrimitivKeitwFluidEvaporator.HALF) == DoubleBlockHalf.UPPER)
			return;
		
		tick++;
		
		if (!inventory.getStackInSlot(0).isEmpty() && burnTime < 1 && !(fluidTank.isEmpty()&&gasAmount<MIN_GAS_AMOUNT)) {

			burnTime += net.minecraftforge.common.ForgeHooks.getBurnTime(inventory.getStackInSlot(0));

			BlockState oldState = world.getBlockState(pos);
			BlockState newState = oldState.with(PrimitivKeitwFluidEvaporator.BURNING_STATE, true);
			world.setBlockState(pos, newState, 2);
			world.notifyNeighborsOfStateChange(pos, newState.getBlock());

			inventory.extractItem(0, inventory.getStackInSlot(0).getCount(), false);
		}

		if (burnTime > 0) {

			if (burnTime > 0)
				burnTime--;

			if (gasAmount < MAX_GAS_AMOUNT) {
				fluidTank.drain(1, FluidAction.EXECUTE);
				gasAmount++;
				world.notifyBlockUpdate(pos, getBlockState(), getBlockState(), 2);
			}
			
			if (burnTime <= 0) {

				BlockState oldState = world.getBlockState(pos);
				BlockState newState = oldState.with(PrimitivKeitwFluidEvaporator.BURNING_STATE, false);
				world.setBlockState(pos, newState, 2);
				world.notifyNeighborsOfStateChange(pos, newState.getBlock());
			}
		}

		if (gasAmount > MIN_GAS_AMOUNT&&(tick%5!=0||(banQuadIntact=banQuadIntact()))&&banQuadIntact) {
			
			IElementalBeeingCapability cap = ((BanQuadPartTileEntity)world.getTileEntity(pos.north())).getElementalCapability();
			
			if(cap!=null) {
			
				energyStorage.receiveEnergy(cap.getElemental().getEnergyOutput(), false);
			}
		}

		if (burnTime <= 0 && gasAmount > 0 && fluidTank.getSpace() > 0) {
			fluidTank.fill(new FluidStack(fluidTank.getFluid(), 1), FluidAction.EXECUTE);
			gasAmount--;
		}

//		System.out.println("--------Evaporator--------");
//		System.out.println(burnTime);
//		System.out.println(gasAmount);
//		System.out.println(energyStorage.getEnergyStored());
	}
	
	private boolean banQuadIntact() {
		BlockState state = world.getBlockState(pos.north());
		if(state.getBlock()==BlockInit.BAN_QUAD_PART.get()&&state.get(BanQuadPartBlock.COMPLETE)&&BanQuadPartBlock.getBanQuadCenter(world, pos.north()).equals(pos)) {
			return true;
		}
		return false;
	}
	
	@Override
	public void read(CompoundNBT compound) {

		inventory.insertItem(0, ItemStack.read(compound.getCompound("items")), false);

		fluidTank.readFromNBT(compound.getCompound("fluid"));

		gasAmount = compound.getInt("gasAmount");
		
		energyStorage = new DefaultElementalEnergieStorage(energyStorage.getMaxEnergyStored());
		energyStorage.receiveEnergy(compound.getInt("energy"), false);
		
		super.read(compound);
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {

		CompoundNBT items = new CompoundNBT();

		inventory.getStackInSlot(0).write(items);

		compound.put("items", items);

		CompoundNBT fluid = new CompoundNBT();

		fluidTank.writeToNBT(fluid);

		compound.put("fluid", fluid);

		compound.putInt("gasAmount", gasAmount);
		
		compound.putInt("energy", energyStorage.getEnergyStored());
		
		return super.write(compound);
	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {

		if (world.getBlockState(this.pos).get(PrimitivKeitwFluidEvaporator.HALF) == DoubleBlockHalf.UPPER) {
			return world.getTileEntity(pos.down()).getCapability(cap, side);
		}

		if (cap == FLUID_CAPABILITY)
			return LazyOptional.of(() -> fluidTank).cast();

		else if (cap == ITEM_CAPABILITY)
			return LazyOptional.of(() -> inventory).cast();

		else if (cap == ELEMENTAL_ENERGY)
			return LazyOptional.of(() -> inventory).cast();

		return super.getCapability(cap, side);
	}

	public static boolean isFluidValid(FluidStack stack) {
		return stack.getFluid().isEquivalentTo(Keitw_Fluid.KEITW_FLUID.get());
	}

	public IItemHandler getInventory() {

		if (world.getBlockState(this.pos).get(PrimitivKeitwFluidEvaporator.HALF) == DoubleBlockHalf.UPPER)
			return ((PrimitvKeitwFluidEvaporatorTileEntity) world.getTileEntity(pos.down())).getInventory();

		return inventory;
	}

	public FluidTank getFluidTank() {

		if (world.getBlockState(this.pos).get(PrimitivKeitwFluidEvaporator.HALF) == DoubleBlockHalf.UPPER)
			return ((PrimitvKeitwFluidEvaporatorTileEntity) world.getTileEntity(pos.down())).getFluidTank();

		return fluidTank;
	}

	public int getGasAmount() {

		if (world.getBlockState(this.pos).get(PrimitivKeitwFluidEvaporator.HALF) == DoubleBlockHalf.UPPER)
			return ((PrimitvKeitwFluidEvaporatorTileEntity) world.getTileEntity(pos.down())).getGasAmount();

		return gasAmount;
	}

	public IElementalEnergyCapability getEnergyStorage() {

		if (world.getBlockState(this.pos).get(PrimitivKeitwFluidEvaporator.HALF) == DoubleBlockHalf.UPPER)
			return ((PrimitvKeitwFluidEvaporatorTileEntity) world.getTileEntity(pos.down())).getEnergyStorage();

		return energyStorage;
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
}
