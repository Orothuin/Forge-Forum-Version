package elementalalchemie.config;

import java.util.ArrayList;
import java.util.List;

import elementalalchemie.ElementalalchemieMod;
import net.minecraftforge.common.ForgeConfigSpec;

public class ElementalAlchemieConfig {
	
	public final ForgeConfigSpec.ConfigValue<List<String>> namesCV;
	private List<String> names = new ArrayList<>();
	
	public ElementalAlchemieConfig(ForgeConfigSpec.Builder builder) {
		
		ArrayList<String> list = new ArrayList<>();
		list.add("Firsty");
		
		builder.push("Elementalbeeingnames");
		namesCV = builder
				.comment("Possible Elementalbeeing names")
				.translation(ElementalalchemieMod.MODID + ".config.elementalbeeingnamelist")
				.define("elementalbeeingnamelist",list);
		builder.pop();
	}

	public void bakeConfig() {
		
		setNames(namesCV.get());
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}
}
