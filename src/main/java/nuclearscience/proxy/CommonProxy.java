package nuclearscience.proxy;

import cpw.mods.fml.common.network.NetworkRegistry;
import nuclearscience.NuclearScience;
import nuclearscience.network.ServerPacketHander;

public class CommonProxy {

	public void load() {
		NuclearScience.dataChannel.register(new ServerPacketHander());
	}

}
