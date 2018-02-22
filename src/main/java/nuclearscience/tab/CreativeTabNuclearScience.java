package nuclearscience.tab;

import ic2.api.item.IC2Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTabNuclearScience extends CreativeTabs{

	public CreativeTabNuclearScience() {
		super("tabNuclear");
	}

	@Override
	public Item getTabIconItem() {
		return IC2Items.getItem("nuke").getItem();
	}

}
