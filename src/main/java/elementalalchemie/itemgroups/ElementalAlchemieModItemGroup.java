package elementalalchemie.itemgroups;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ElementalAlchemieModItemGroup extends ItemGroup{
	
	public static final ElementalAlchemieModItemGroup INSTANCE = new ElementalAlchemieModItemGroup(ItemGroup.GROUPS.length,"moditemgroup");
	
	public ElementalAlchemieModItemGroup(int index, String label) {
		super(index, label);
	}

	@Override
	public ItemStack createIcon() {
		
		return ItemStack.EMPTY;
	}
}
