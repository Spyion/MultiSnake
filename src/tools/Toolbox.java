package tools;

import org.newdawn.slick.geom.Vector2f;

public class Toolbox {
	public static double getDistance(Vector2f point1, Vector2f point2){
		return Math.sqrt(Math.pow(point1.x-point2.x, 2)+Math.pow(point1.y-point2.y, 2));
	}
	public static double getDistance(float x1, float y1, float x2, float y2){
		return getDistance(new Vector2f(x1, y1), new Vector2f(x2, y2));
	}
	public static Vector2f getDistanceVector(Vector2f point1, Vector2f point2){
		return new Vector2f(point1.x-point2.x, point1.y-point2.y);
	}public static Vector2f getDistanceVector(float x1, float y1, float x2, float y2){
		return getDistanceVector(new Vector2f(x1, y1), new Vector2f(x2, y2));
	}
	public static void approachVector(final Vector2f approaching, final Vector2f target, float factor,int delta){
		Vector2f distance = Toolbox.getDistanceVector(target, approaching);
		distance.scale((float) Math.pow(factor, delta));
		if(distance.length() > 0.001f)
			approaching.set(Toolbox.getDistanceVector(target, distance));
		else 
			approaching.set(target);
	}
}
