package elementalalchemie.init;

import java.awt.Color;

import elementalalchemie.ElementalalchemieMod;
import elementalalchemie.fluids.Keitw_Fluid;
import elementalalchemie.itemgroups.ElementalAlchemieModItemGroup;
import elementalalchemie.items.KeitwFluidBucket;
import elementalalchemie.items.CustomSpawnEggItem;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.Items;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS,
			ElementalalchemieMod.MODID);
	
	
	public static final RegistryObject<Item> KEITW_SEED = ITEMS.register("keitw_seed",() -> new BlockNamedItem(BlockInit.KEITW_PLANT_BLOCK.get(),new Properties().group(ElementalAlchemieModItemGroup.INSTANCE)));
	
	public static final RegistryObject<Item> KEITW_FRUIT = ITEMS.register("keitw_fruit", ()-> new Item(new Properties().group(ElementalAlchemieModItemGroup.INSTANCE).food((new Food.Builder()).hunger(4).saturation(0.3F).build())));
	public static final RegistryObject<Item> KEITW_TWIG = ITEMS.register("keitw_twig", ()->new Item(new Properties().group(ElementalAlchemieModItemGroup.INSTANCE)));
	
	public static final RegistryObject<Item> KEITW_FLUID_BUCKET = ITEMS.register("keitw_fluid_bucket", ()->new KeitwFluidBucket(Keitw_Fluid.KEITW_FLUID::get,new Properties().group(ElementalAlchemieModItemGroup.INSTANCE).containerItem(Items.BUCKET).maxStackSize(1)));
	
	public static final RegistryObject<Item> PESTLE = ITEMS.register("pestel", ()-> new Item(new Properties().group(ElementalAlchemieModItemGroup.INSTANCE)));
	
	public static final RegistryObject<Item> STONE_TURTLE_CRYSTAL = ITEMS.register("stone_turtle_crystal", ()-> new Item(new Properties().group(ElementalAlchemieModItemGroup.INSTANCE)));
	
	public static final RegistryObject<Item> STONE_TURTLE_SPAWNEGG = ITEMS.register("stone_turtle_spawnegg", ()-> new CustomSpawnEggItem(EntityTypeInit.STONE_TURTLE, new Color(50, 50, 50).getRGB(),  new Color(248, 166, 34).getRGB(), new Properties().group(ElementalAlchemieModItemGroup.INSTANCE)));
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
	
		for(RegistryObject<? extends Block> b : BlockInit.itemblocks) {
			
			Item item = new BlockItem(b.get(), new Properties().group(ElementalAlchemieModItemGroup.INSTANCE));
			item.setRegistryName(b.get().getRegistryName());
			registry.register(item);
			
		}
	}
}
