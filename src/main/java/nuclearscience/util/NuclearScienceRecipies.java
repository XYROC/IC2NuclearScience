package nuclearscience.util;

import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.item.IC2Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import nuclearscience.block.NuclearScienceBlocks;
import nuclearscience.item.NuclearScienceItems;

public class NuclearScienceRecipies {

	public static void registerRecipies() {
		ItemStack lapotronCrystal = IC2Items.getItem("lapotronCrystal");
		lapotronCrystal.setItemDamage(26);
		
		ItemStack lapotronStorage = new ItemStack(NuclearScienceItems.lapotronStorgageUnit);
		lapotronStorage.setItemDamage(26);

		GameRegistry.addRecipe(new ShapedOreRecipe(NuclearScienceItems.lapotronStorgageUnit, "lcl", "mlm", "lml", 'l',
				lapotronCrystal, 'm', IC2Items.getItem("plateadviron"), 'c', "ingotCopper"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NuclearScienceBlocks.lapotronStorage), "mhm", "bab", "lml", 'm',
				IC2Items.getItem("plateadviron"), 'h', "ingotCopper", 'b',
				IC2Items.getItem("advancedCircuit"), 'a', IC2Items.getItem("advancedMachine"), 'l', lapotronStorage));
	}

}