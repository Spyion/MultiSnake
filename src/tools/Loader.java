package tools;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Loader {
	private static final String root = "resources/";
	public static Image loadImage(String ref) {
		try {
			return new Image(root+ref);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		return null;
	}
}
