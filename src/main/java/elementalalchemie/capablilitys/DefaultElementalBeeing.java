package elementalalchemie.capablilitys;

import java.util.Random;

import elementalalchemie.elementalbeeing.ElementalBeeing;
import elementalalchemie.init.CapabilityInit;
import elementalalchemie.init.ConfigInit;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;

public class DefaultElementalBeeing implements IElementalBeeingCapability {

	private ElementalBeeing elementalBeeing;

	public DefaultElementalBeeing() {
		elementalBeeing = new ElementalBeeing(
				ConfigInit.MOD_CONFIG.getNames().get(ConfigInit.MOD_CONFIG.getNames().size() < 2 ? 0
						: new Random().nextInt(ConfigInit.MOD_CONFIG.getNames().size() - 1)));

	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {

		if (cap == CapabilityInit.ELEMENTAL_BEEING)
			return LazyOptional.of(() -> this).cast();

		return null;
	}

	@Override
	public INBT serializeNBT() {

		return elementalBeeing.serializeNBT();
	}

	@Override
	public void deserializeNBT(INBT nbt) {

		elementalBeeing.deserializeNBT(nbt);
	}

	@Override
	public ElementalBeeing getElemental() {

		return elementalBeeing;
	}

}
