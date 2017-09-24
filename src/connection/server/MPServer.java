package connection.server;

import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;

import connection.packages.Register;

public class MPServer {
	private Server server;
	
	public MPServer(int TCPPort, int UDPPort){
		
		server = new Server();
		Register.registerPackets(server.getKryo());
		server.addListener(new NetworkListener(server));
		try {
			server.bind(TCPPort, UDPPort);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		server.start();
	}
}
