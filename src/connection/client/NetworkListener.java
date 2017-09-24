package connection.client;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import connection.packages.ConnectionAnswer;
import connection.packages.Snake;
import entities.SimulatedSnake;
import gamestates.Running;

public class NetworkListener extends Listener{
	
	public NetworkListener(Running running) {
		this.running = running;
	}
	public Running running;
	private int ID = -1;
	@Override
	public void received(Connection c, Object o) {
		if(o instanceof Snake) {
			Snake s = (Snake)o;
			SimulatedSnake snake = running.getSnakeByID(s.ID);
			if(snake == null) {
				running.addSnake(snake = new SimulatedSnake(s.ID));
			}
			snake.set(s.x, s.y, s.sizes);
		}else if(o instanceof ConnectionAnswer) {
			ID = ((ConnectionAnswer) o).ID;
		}
		super.received(c, o);
	}
	
	public int getID() {
		return ID;
	}
}
