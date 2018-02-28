package nuclearscience.network;

import java.io.IOException;
import java.util.UUID;

import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nuclearscience.NuclearScience;
import nuclearscience.item.ItemEnergyStorage;
import nuclearscience.tile.TileEntityEnergyStorage;

public class Packets {

	public static final int packetTileData = 0;

	public static FMLProxyPacket createTileEnergyPacket(TileEntityEnergyStorage tile) throws IOException {
		ByteBufOutputStream bbos = new ByteBufOutputStream(Unpooled.buffer());
		bbos.writeInt(packetTileData);
		bbos.writeInt(tile.xCoord);
		bbos.writeInt(tile.yCoord);
		bbos.writeInt(tile.zCoord);
		bbos.writeDouble(tile.energy);
		FMLProxyPacket packet = new FMLProxyPacket(bbos.buffer(), NuclearScience.name);
		bbos.close();
		return packet;
	}

	public static void processPacketOnClientSide(ByteBuf parBB, Side parSide) throws IOException {
		if (parSide == Side.CLIENT) {
			World world = Minecraft.getMinecraft().theWorld;
			ByteBufInputStream bbis = new ByteBufInputStream(parBB);
			int packetTypeID = bbis.readInt();
			switch (packetTypeID) {
			case packetTileData: {
				int x = bbis.readInt();
				int y = bbis.readInt();
				int z = bbis.readInt();
				double energy = bbis.readDouble();
				TileEntityEnergyStorage tile = (TileEntityEnergyStorage) Minecraft.getMinecraft().theWorld
						.getTileEntity(x, y, z);
				if (tile == null) {
					NuclearScience.warn("Failed to update tileEntity (nullPointer)");
					bbis.close();
					return;
				}
				tile.energy = energy;
				break;
			}
			}
			bbis.close();
		}
	}

}
