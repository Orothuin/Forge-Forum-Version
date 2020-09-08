package elementalalchemie.init;

import elementalalchemie.ElementalalchemieMod;
import elementalalchemie.recipes.ExtractJuiceRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeSerializerInit {
	
	public static final DeferredRegister<IRecipeSerializer<?>> SERIALIZERS = new DeferredRegister<>(
			ForgeRegistries.RECIPE_SERIALIZERS, ElementalalchemieMod.MODID);
	
	public static final RegistryObject<IRecipeSerializer<?>> JUICE_EXTRACTOR_RECIPES = SERIALIZERS.register("extract_juice", ()->new ExtractJuiceRecipe.Serializer());
}
