package elementalalchemie.elementalbeeing;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;

public class ElementalBeeing {
	
	private String name;
	
	private int level;
	
	//per tick
	private int energyOutput=2;
	
	private int friendshipLevel;
	
	private float friendshipMultiplyier;
	
	
	public ElementalBeeing(String name) {
		this.name=name;
	}
	
	
	public INBT serializeNBT() {
		
		CompoundNBT nbt = new CompoundNBT();
		
		nbt.putString("name", name);
		nbt.putInt("level", level);
		nbt.putInt("energyoutput", energyOutput);
		nbt.putInt("friendshiplevel", friendshipLevel);
		nbt.putFloat("friendshipmultiplyier", friendshipMultiplyier);
		
		return nbt;
	}


	public void deserializeNBT(INBT nbt) {
		
		CompoundNBT nbtC = (CompoundNBT)nbt;
		name = nbtC.getString("name");
		level = nbtC.getInt("level");
		energyOutput = nbtC.getInt("energyoutput");
		friendshipLevel = nbtC.getInt("friendshiplevel");
		friendshipMultiplyier = nbtC.getFloat("friendshipmultiplyier");
	}
	
	public String getName() {
		return name;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getEnergyOutput() {
		return energyOutput;
	}

	public void setEnergyOutput(int energyOutput) {
		this.energyOutput = energyOutput;
	}

	public int getFriendshipLevel() {
		return friendshipLevel;
	}

	public void setFriendshipLevel(int friendshipLevel) {
		this.friendshipLevel = friendshipLevel;
	}

	public float getFriendshipMultiplikator() {
		return friendshipMultiplyier;
	}

	public void setFriendshipMultiplikator(float friendshipMultiplikator) {
		this.friendshipMultiplyier = friendshipMultiplikator;
	}

	
}
