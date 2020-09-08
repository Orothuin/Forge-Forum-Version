package elementalalchemie.tileentitys;

import elementalalchemie.capablilitys.IElementalBeeingCapability;
import elementalalchemie.init.CapabilityInit;
import elementalalchemie.init.TileEntityTypeInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;

public class BanQuadPartTileEntity extends TileEntity{
	
	private LivingEntity placer;

	
	public BanQuadPartTileEntity() {
		super(TileEntityTypeInit.BAN_QUAD_PART_TE.get());
	
	}
	
	public LivingEntity getPlacer() {
		return placer;
	}

	public void setPlacer(LivingEntity placer) {
		this.placer = placer;
	}
	
	public IElementalBeeingCapability getElementalCapability() {
		
		if(placer!=null)
		return placer.getCapability(CapabilityInit.ELEMENTAL_BEEING, Direction.NORTH).orElse(null);
		return null;
	}
}
