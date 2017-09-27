package tools;

public class Vector2f extends org.newdawn.slick.geom.Vector2f{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Vector2f add(float x, float y) {
		this.x+=x;
		this.y+=y;
		return this;
	}

	public Vector2f() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vector2f(double theta) {
		super(theta);
		// TODO Auto-generated constructor stub
	}

	public Vector2f(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public Vector2f(float[] coords) {
		super(coords);
		// TODO Auto-generated constructor stub
	}

	public Vector2f(org.newdawn.slick.geom.Vector2f other) {
		super(other);
	}
	
}
