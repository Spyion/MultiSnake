package connection.server;

import java.util.ArrayList;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import connection.packages.Snake;

public class NetworkListener extends Listener{
	ArrayList<Connection> connections = new ArrayList<Connection>();
	Server server;
	public NetworkListener(Server server) {
		this.server = server;
	}
	
	@Override
	public void connected(Connection c) {
		connections.add(c);
		super.connected(c);
	}
	@Override
	public void disconnected(Connection c) {
		connections.remove(c);
		super.disconnected(c);
	}
	@Override
	public void received(Connection c, Object o) {
		if(o instanceof Snake) {
			server.sendToAllExceptUDP(c.getID(), o);
		}
		super.received(c, o);
	}
}
