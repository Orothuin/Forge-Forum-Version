package elementalalchemie.init;



import org.apache.commons.lang3.tuple.Pair;

import elementalalchemie.config.ElementalAlchemieConfig;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;


public class ConfigInit {
	
	private static final Pair<ElementalAlchemieConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ElementalAlchemieConfig::new);
	public static final ForgeConfigSpec MOD_CONFIG_SPEC = specPair.getRight();
	public static final ElementalAlchemieConfig MOD_CONFIG = specPair.getLeft();
	
	@SubscribeEvent
	public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
		MOD_CONFIG.bakeConfig();
	}

}
