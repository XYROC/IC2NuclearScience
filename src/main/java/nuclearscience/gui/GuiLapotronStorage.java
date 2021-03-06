package nuclearscience.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import nuclearscience.NuclearScience;
import nuclearscience.gui.container.ContainerLapotronStorage;
import nuclearscience.tile.TileEntityLaptronStorage;
import nuclearscience.util.AdvancedPosition;
import nuclearscience.util.ElementSimpleScaled;

public class GuiLapotronStorage extends GuiContainer {

	Minecraft mc = Minecraft.getMinecraft();
	
	ResourceLocation gui = new ResourceLocation("nuclearscience:textures/gui/GUILSU.png");

	TileEntityLaptronStorage tile;
	AdvancedPosition tilePos;

	public GuiLapotronStorage(ContainerLapotronStorage container, AdvancedPosition tilePos) {
		super(container);
		this.tilePos = tilePos;
		this.tile = (TileEntityLaptronStorage) tilePos.getTileEntity();
	}

	@Override
	public void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
		tile = (TileEntityLaptronStorage) tilePos.getTileEntity();
		int energy = tile.getStored();
		int maxEnergy = tile.getCapacity();
		double filled = (double) energy / (double) maxEnergy;
		double length = filled * 23;
		if(filled > 0.0D) length += 1.0D;
		ElementSimpleScaled energyBar = new ElementSimpleScaled(gui, 75, 34, (int) length, 17, 176, 14);
		energyBar.draw(this);
	}

	@Override
	public void drawScreen(int par1, int par2, float p_73863_3_) {
		super.drawScreen(par1, par2, p_73863_3_);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		if (par1 > k + 70 && par1 < k + 103 && par2 > l + 34 && par2 < l + 51) {
			List lore = new ArrayList<String>();
			lore.add("Energy: " + tile.getStored() + " / 100M EU");
			drawHoveringText(lore, par1, par2, fontRendererObj);
		}
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		mc.renderEngine.bindTexture(gui);
		drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
	}

}
