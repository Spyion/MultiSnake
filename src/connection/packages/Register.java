package connection.packages;

import com.esotericsoftware.kryo.Kryo;

public class Register {
	public static void registerPackets(Kryo kryo) {
		kryo.register(Snake.class);
		kryo.register(ConnectionRequest.class);
		kryo.register(ConnectionAnswer.class);
	}
}
