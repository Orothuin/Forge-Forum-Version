package elementalalchemie.capablilitys;

import java.util.concurrent.Callable;

import elementalalchemie.elementalbeeing.ElementalBeeing;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public interface IElementalBeeingCapability extends ICapabilitySerializable<INBT> {
	
	public ElementalBeeing getElemental();
	
	public static class Storage implements Capability.IStorage<IElementalBeeingCapability> {

		@Override
		public INBT writeNBT(Capability<IElementalBeeingCapability> capability, IElementalBeeingCapability instance,
				Direction side) {

			return instance.serializeNBT();
		}

		@Override
		public void readNBT(Capability<IElementalBeeingCapability> capability, IElementalBeeingCapability instance,
				Direction side, INBT nbt) {
			instance.deserializeNBT(nbt);
		}
	}

	public static class Factory implements Callable<IElementalBeeingCapability> {

		@Override
		public IElementalBeeingCapability call() throws Exception {
			return new DefaultElementalBeeing();
		}
	}
}
