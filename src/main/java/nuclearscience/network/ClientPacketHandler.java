package nuclearscience.network;

import java.io.IOException;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientCustomPacketEvent;
import nuclearscience.NuclearScience;

public class ClientPacketHandler {

	protected String channelName;

	@SubscribeEvent
	public void onClientPacket(ClientCustomPacketEvent event) throws IOException {
		this.channelName = event.packet.channel();
		if (channelName.equals(NuclearScience.name)) {
			Packets.processPacketOnClientSide(event.packet.payload(), event.packet.getTarget());
		}
	}

}
