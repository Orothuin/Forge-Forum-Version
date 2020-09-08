package elementalalchemie;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.items.IItemHandler;

public class InventoryUtil {
	
	public static boolean containsItem(IItemHandler inv, ItemStack itemstack) {
		
		for(int i=0;i<inv.getSlots();i++)
			if(ItemStack.areItemsEqual(inv.getStackInSlot(i), itemstack))return true;
		
		return false;
	}
	
	public static ItemStack extractFirstOccurenceOf(IItemHandler inv, ItemStack itemstack) {
		int slot =-1;
		for(int i=0;i<inv.getSlots();i++)
			if(ItemStack.areItemsEqual(inv.getStackInSlot(i), itemstack)) {
				slot=i;
				break;
			}
		
		if(slot>=0)
			return inv.extractItem(slot, inv.getStackInSlot(slot).getCount(), false);
		
		return ItemStack.EMPTY;
		
	}
	
	public static boolean isEmpty(IItemHandler inv) {
		
		for(int i=0;i<inv.getSlots();i++)
			if(!inv.getStackInSlot(i).isEmpty()) return false;
		return true;
	}
	
	public static ItemStack extractStack(IItemHandler inv, int slot) {
		return inv.extractItem(slot, inv.getStackInSlot(slot).getCount(), false);
	}
	
	public static boolean insertFreeSlot(IItemHandler inv, ItemStack itemstack) {
		
		for(int i=0;i<inv.getSlots();i++) {
			if(inv.getStackInSlot(i).isEmpty()) {
				inv.insertItem(i, itemstack, false);
				return true;
			}
		}
		return false;
	}
	
	public static IInventory parse(IItemHandler inv) {
		IInventory inv2 = new Inventory(inv.getSlots());
		
		for(int i=0;i<inv.getSlots();i++)
			inv2.setInventorySlotContents(i, inv.getStackInSlot(i));
		
		return inv2;
	}
	public static int slotsFilled(IItemHandler inv) {
		int k =0;
		
		for(int i=0;i<inv.getSlots();i++)
			if(!inv.getStackInSlot(i).isEmpty())k++;
		
		
		return k;
	}
	
	public static NonNullList<ItemStack> getInvAsList(IItemHandler inv){
		NonNullList<ItemStack> list = NonNullList.withSize(Math.max(inv.getSlots(),1), ItemStack.EMPTY);
		
		
		
		for(int i=0;i<inv.getSlots();i++)
			
			list.add(i, (inv.getStackInSlot(i)==null ? ItemStack.EMPTY :  inv.getStackInSlot(i)));
		
		return list;
	}
	
	public static void fillInvFromList(NonNullList<ItemStack> list, IItemHandler inv) {
		
		for(int i=0;i<list.size();i++)
			if(i<inv.getSlots())
			inv.insertItem(i, list.get(i), false);
	}
}
