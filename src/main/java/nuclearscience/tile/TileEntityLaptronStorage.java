package nuclearscience.tile;

import java.io.IOException;

import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergyEmitter;
import ic2.api.energy.tile.IEnergySink;
import ic2.api.energy.tile.IEnergySource;
import ic2.api.tile.IEnergyStorage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;
import nuclearscience.NuclearScience;
import nuclearscience.network.Packets;

public class TileEntityLaptronStorage extends TileEntityEnergyStorage {

	public TileEntityLaptronStorage() {
		super(100000000.0D, 4, 4096);
	}
	
}
