package elementalalchemie.init;

import elementalalchemie.ElementalalchemieMod;
import elementalalchemie.capablilitys.DefaultElementalBeeing;
import elementalalchemie.capablilitys.IElementalBeeingCapability;
import elementalalchemie.capablilitys.IElementalEnergyCapability;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CapabilityInit {

	@CapabilityInject(IElementalEnergyCapability.class)
	public static Capability<IElementalEnergyCapability> ELEMENTAL_ENERGY;
	
	@CapabilityInject(IElementalEnergyCapability.class)
	public static Capability<IElementalBeeingCapability> ELEMENTAL_BEEING;
	
	public static void init() {
		CapabilityManager.INSTANCE.register(IElementalEnergyCapability.class,new IElementalEnergyCapability.Storage(),new IElementalEnergyCapability.Factory());
	
		CapabilityManager.INSTANCE.register(IElementalBeeingCapability.class,new IElementalBeeingCapability.Storage(),new IElementalBeeingCapability.Factory());

	}
	
	 @SubscribeEvent
		public static void registerCapabilitysToEntitys(AttachCapabilitiesEvent<Entity> event) {
			
			if(event.getObject() instanceof PlayerEntity) {
				event.addCapability(new ResourceLocation(ElementalalchemieMod.MODID, "elementalbeeing"), new DefaultElementalBeeing());
			}
		}
}
