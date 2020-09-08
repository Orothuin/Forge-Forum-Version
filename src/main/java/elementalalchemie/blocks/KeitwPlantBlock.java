package elementalalchemie.blocks;

import elementalalchemie.init.ItemInit;
import net.minecraft.block.CropsBlock;
import net.minecraft.util.IItemProvider;

public class KeitwPlantBlock extends CropsBlock{

	public KeitwPlantBlock(Properties builder) {
		super(builder);
	}
	
	@Override
	protected IItemProvider getSeedsItem() {
		
		return ItemInit.KEITW_SEED.get();
	}
}
