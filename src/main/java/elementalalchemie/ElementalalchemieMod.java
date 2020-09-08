package elementalalchemie;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import elementalalchemie.client.ClientInit;
import elementalalchemie.init.BlockInit;
import elementalalchemie.init.CapabilityInit;
import elementalalchemie.init.ConfigInit;
import elementalalchemie.init.EntityTypeInit;
import elementalalchemie.init.FluidInit;
import elementalalchemie.init.ItemInit;
import elementalalchemie.init.RecipeSerializerInit;
import elementalalchemie.init.TileEntityTypeInit;
import elementalalchemie.items.CustomSpawnEggItem;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

@Mod("elementalalchemie")
public class ElementalalchemieMod
{
    
	public static final String MODID = "elementalalchemie";
	
    private static final Logger LOGGER = LogManager.getLogger();

    public ElementalalchemieMod() {
    	
    	
    	
    	IEventBus eventbus = FMLJavaModLoadingContext.get().getModEventBus();
    	
        eventbus.addListener(this::setup);
        
        eventbus.addListener(this::doClientStuff);
        
        FluidInit.FLUIDS.register(eventbus);
        BlockInit.BLOCKS.register(eventbus);
        
        ItemInit.ITEMS.register(eventbus);
        
        EntityTypeInit.ENTITY_TYPES.register(eventbus);
        
        TileEntityTypeInit.TILEENTITY_TYPES.register(eventbus);
        RecipeSerializerInit.SERIALIZERS.register(eventbus);
        
        MinecraftForge.EVENT_BUS.register(CapabilityInit.class);
        
        eventbus.register(ItemInit.class);
        eventbus.register(ConfigInit.class);
        eventbus.register(ClientInit.class);
        //MinecraftForge.EVENT_BUS.register(ClientInit.class);
        
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigInit.MOD_CONFIG_SPEC);
        
        MinecraftForge.EVENT_BUS.register(this);
        
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	for(Biome b : ForgeRegistries.BIOMES)
    		b.getSpawns(EntityClassification.AMBIENT).add(new SpawnListEntry(EntityTypeInit.STONE_TURTLE.get(), 40, 3, 3));
    	
    	EntityTypeInit.init();
    	CustomSpawnEggItem.registerEggs();
    	CapabilityInit.init();
    	
        LOGGER.info("HELLO FROM PREINIT");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    	
    	ClientInit.init();
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }
    
    
   
   
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        
        LOGGER.info("HELLO from server starting");
    }
}
