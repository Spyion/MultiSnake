package connection.client;

import java.io.IOException;

import com.esotericsoftware.kryonet.Client;

import connection.packages.ConnectionRequest;
import connection.packages.Register;
import gamestates.Running;

public class MPClient {
	Client client;
	
	public MPClient(Running running, String IP, int TCPPort, int UCPPort) {
		client = new Client();
		Register.registerPackets(client.getKryo());
		client.addListener(new NetworkListener(running));

		try {
			client.start();
			client.connect(5000, IP, TCPPort, UCPPort);
			sendUDP(new ConnectionRequest());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void sendUDP(Object o) {
		client.sendUDP(o);
	}
	public void sendTCP(Object o) {
		client.sendTCP(o);
	}
}
