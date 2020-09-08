package elementalalchemie.items;

import java.util.ArrayList;
import java.util.Map;

import elementalalchemie.DispenseBehaviors;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class CustomSpawnEggItem extends SpawnEggItem {

	private Lazy<? extends EntityType<?>> type;

	private static ArrayList<SpawnEggItem> toBeRegistered = new ArrayList<>();

	public CustomSpawnEggItem(RegistryObject<? extends EntityType<?>> typeIn, int primaryColorIn, int secondaryColorIn,
			Properties builder) {

		super(null, primaryColorIn, secondaryColorIn, builder);
		type = Lazy.of(typeIn::get);
		toBeRegistered.add(this);

	}

	public static void registerEggs() {

		final Map<EntityType<?>, SpawnEggItem> EGGS = ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class,
				null, "field_195987_b");
		for (SpawnEggItem item : toBeRegistered) {
			EGGS.put(item.getType(null), (SpawnEggItem) item);
			DispenserBlock.registerDispenseBehavior(item, DispenseBehaviors.SPAWN_EGG_BEHAVIOR);
		}
		toBeRegistered.clear();
	}

	@Override
	public EntityType<?> getType(CompoundNBT p_208076_1_) {
		return type.get();
	}
}
