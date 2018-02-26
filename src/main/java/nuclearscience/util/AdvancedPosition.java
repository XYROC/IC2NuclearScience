package nuclearscience.util;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class AdvancedPosition {
	
	private World worldObj;
	private final int x;
	private final int y;
	private final int z;
	
	public AdvancedPosition(World worldObj, int x, int y, int z) {
		this.worldObj = worldObj;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public World getWorld() {
		return worldObj;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}
	
	public TileEntity getTileEntity() {
		return worldObj.getTileEntity(x, y, z);
	}

}
