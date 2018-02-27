package nuclearscience.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import nuclearscience.block.item.ItemBlockLapotronStorage;
import nuclearscience.tile.TileEntityLaptronStorage;

public class NuclearScienceBlocks {

	public static final Block lapotronStorage = new BlockLapotronStorage();
	
	public static void registerBlocks() {
		GameRegistry.registerBlock(lapotronStorage, ItemBlockLapotronStorage.class, "lapotronStorage");
		
		GameRegistry.registerTileEntity(TileEntityLaptronStorage.class, "lapotronStorage");
		
		LanguageRegistry.addName(lapotronStorage, "Lapotron Storage");
	}

}
