package entities;

import java.util.ArrayList;

import org.newdawn.slick.geom.Vector2f;

import tools.Toolbox;

public class SimulatedSnake {
	ArrayList<Vector2f> positions = new ArrayList<Vector2f>();
	ArrayList<Vector2f> targetPositions = new ArrayList<Vector2f>();
	ArrayList<Float> sizes = new ArrayList<Float>();
	public int ID;
	
	public SimulatedSnake(int ID) {
		this.ID = ID;
	}
	
	public void set(float[] x, float[] y, float[] sizes) {
		
		this.sizes.clear();
		for(float i : sizes) {
			this.sizes.add(i);
		}
		
		for(int i = 0; i < x.length; i++) {
			{
				Vector2f v = positions.get(i);
				if(v == null) {
					positions.add(new Vector2f(x[i], y[i]));
				}
				
			}{
				Vector2f v = targetPositions.get(i);
				if(v == null) {
					targetPositions.add(v = new Vector2f());
				}
				v.set(x[i], y[i]);
			}
		}
	}
	public void update(int delta) {
		for (int i = 0; i < positions.size(); i++) {
			Toolbox.approachVector(positions.get(i), targetPositions.get(i), 0.995f, delta);
		}
	}
}
