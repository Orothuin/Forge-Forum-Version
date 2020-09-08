package elementalalchemie.capablilitys;

import java.util.concurrent.Callable;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.IEnergyStorage;

public interface IElementalEnergyCapability extends IEnergyStorage {

	public static class Storage implements Capability.IStorage<IElementalEnergyCapability> {

		@Override
		public INBT writeNBT(Capability<IElementalEnergyCapability> capability, IElementalEnergyCapability instance,
				Direction side) {

			return null;
		}

		@Override
		public void readNBT(Capability<IElementalEnergyCapability> capability, IElementalEnergyCapability instance,
				Direction side, INBT nbt) {

		}
	}

	public static class Factory implements Callable<IElementalEnergyCapability> {

		@Override
		public IElementalEnergyCapability call() throws Exception {
			return new DefaultElementalEnergieStorage(1);
		}
	}
}
