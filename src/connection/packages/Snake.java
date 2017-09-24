package connection.packages;

public class Snake {
	public float[] x;
	public float[] y;
	public float[] sizes;
	public int ID;
	
	
	public Snake() {
	}
	public Snake setX(float ... x) {
		this.x = x;
		return this;
	}
	public Snake setY(float ... y) {
		this.y = y;
		return this;
	}
	public Snake setSizes(float ... s) {
		this.sizes = s;
		return this;
	}
	public Snake setID(int ID) {
		this.ID = ID;
		return this;
	}
}
