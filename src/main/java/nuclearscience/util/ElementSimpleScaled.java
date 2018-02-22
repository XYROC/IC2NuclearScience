package nuclearscience.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class ElementSimpleScaled {

	private ResourceLocation texture;

	private int xSize;
	private int ySize;
	private int xPos;
	private int yPos;
	private int textureX;
	private int textureY;

	public ElementSimpleScaled(ResourceLocation texture, int xPos, int yPos, int xSize, int ySize, int textureX,
			int textureY) {
		this.texture = texture;
		this.xPos = xPos;
		this.yPos = yPos;
		this.xSize = xSize;
		this.ySize = ySize;
		this.textureX = textureX;
		this.textureY = textureY;
	}

	@SideOnly(Side.CLIENT)
	public void draw(GuiScreen screen) {
		screen.mc.renderEngine.bindTexture(texture);
		screen.drawTexturedModalRect(xPos, yPos, textureX, textureY, xSize, ySize);
	}

	public void setxSize(int xSize) {
		this.xSize = xSize;
	}

	public void setySize(int ySize) {
		this.ySize = ySize;
	}

	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public int getySize() {
		return ySize;
	}

	public int getxSize() {
		return xSize;
	}

}