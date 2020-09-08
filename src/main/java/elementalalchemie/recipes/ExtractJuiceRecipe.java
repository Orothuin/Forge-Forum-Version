package elementalalchemie.recipes;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import elementalalchemie.init.RecipeSerializerInit;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class ExtractJuiceRecipe implements IRecipe<IInventory> {

	public static final IRecipeType<ExtractJuiceRecipe> EXTRACT_JUICE = register("extract_juice");

	static <T extends IRecipe<?>> IRecipeType<T> register(final String key) {
		return Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(key), new IRecipeType<T>() {
			public String toString() {
				return key;
			}
		});
	}

	public NonNullList<Ingredient> ingriedients;
	public ItemStack recipeOutput;
	public ResourceLocation id;

	public ExtractJuiceRecipe(ResourceLocation id, ItemStack recipeOutput, NonNullList<Ingredient> ingriedients) {
		this.ingriedients = ingriedients;
		this.recipeOutput = recipeOutput;
		this.id = id;
	}

	@Override
	public boolean matches(IInventory inv, World worldIn) {

		ArrayList<ItemStack> list = new ArrayList<>();
		
		for (int i = 0; i < inv.getSizeInventory(); i++)
			if (!inv.getStackInSlot(i).isEmpty())
				list.add(inv.getStackInSlot(i));
		
		if(ingriedients.size()!=list.size())return false;
			
		for (Ingredient i : ingriedients) {
			
			boolean b = false;
			ItemStack stack = ItemStack.EMPTY;
			
			for (ItemStack s : list)
				if (i.test(s)) {
					b = true;
					stack=s;
				}
			if (!b)
				return false;
			
			list.remove(stack);
		}
		return true;
	}

	@Override
	public ItemStack getCraftingResult(IInventory inv) {

		return this.recipeOutput;
	}

	@Override
	public boolean canFit(int width, int height) {

		return true;
	}

	@Override
	public ItemStack getRecipeOutput() {

		return this.recipeOutput;
	}

	@Override
	public ResourceLocation getId() {

		return id;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {

		return RecipeSerializerInit.JUICE_EXTRACTOR_RECIPES.get();
	}

	@Override
	public IRecipeType<?> getType() {

		return EXTRACT_JUICE;
	}

	public static class Serializer extends net.minecraftforge.registries.ForgeRegistryEntry<IRecipeSerializer<?>>
			implements IRecipeSerializer<ExtractJuiceRecipe> {

		@Override
		public ExtractJuiceRecipe read(ResourceLocation recipeId, JsonObject json) {

			NonNullList<Ingredient> nonnulllist = readIngredients(JSONUtils.getJsonArray(json, "ingredients"));
			if (nonnulllist.isEmpty()) {
				throw new JsonParseException("No ingredients for shapeless recipe");
			} else {
				ItemStack itemstack = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "result"));
				return new ExtractJuiceRecipe(recipeId, itemstack, nonnulllist);
			}
		}

		private static NonNullList<Ingredient> readIngredients(JsonArray ingriedients) {
			NonNullList<Ingredient> nonnulllist = NonNullList.create();

			for (int i = 0; i < ingriedients.size(); ++i) {
				Ingredient ingredient = Ingredient.deserialize(ingriedients.get(i));
				if (!ingredient.hasNoMatchingItems()) {
					nonnulllist.add(ingredient);
				}
			}

			return nonnulllist;
		}

		@Override
		public ExtractJuiceRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {

			NonNullList<Ingredient> nonnulllist = NonNullList.withSize(buffer.readVarInt(), Ingredient.EMPTY);

			for (int j = 0; j < nonnulllist.size(); ++j) {
				nonnulllist.set(j, Ingredient.read(buffer));
			}

			ItemStack itemstack = buffer.readItemStack();
			return new ExtractJuiceRecipe(recipeId, itemstack, nonnulllist);
		}

		@Override
		public void write(PacketBuffer buffer, ExtractJuiceRecipe recipe) {
			buffer.writeVarInt(recipe.ingriedients.size());

			for (Ingredient ingredient : recipe.ingriedients) {
				ingredient.write(buffer);
			}

			buffer.writeItemStack(recipe.recipeOutput);

		}
	}

}
