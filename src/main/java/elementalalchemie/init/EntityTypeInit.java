package elementalalchemie.init;

import elementalalchemie.ElementalalchemieMod;
import elementalalchemie.entitys.StoneTurtleEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeInit {
	
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, ElementalalchemieMod.MODID);
	
	public static final RegistryObject<EntityType<StoneTurtleEntity>> STONE_TURTLE = ENTITY_TYPES.register("turtleentity", () -> EntityType.Builder.<StoneTurtleEntity>create(StoneTurtleEntity::new, EntityClassification.CREATURE)
			.size(0.98f, 0.9f).build(new ResourceLocation(ElementalalchemieMod.MODID + ":turtleentity").toString()));
	
	
	public static void init() {
		EntitySpawnPlacementRegistry.register(STONE_TURTLE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, StoneTurtleEntity::shouldSpawn);
		
	}
}
