package nuclearscience.proxy;

import nuclearscience.NuclearScience;
import nuclearscience.network.ClientPacketHandler;

public class ClientProxy extends CommonProxy {

	@Override
	public void load() {
		NuclearScience.dataChannel.register(new ClientPacketHandler());
	}

}
