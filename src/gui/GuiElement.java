package gui;


import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import tools.Loader;

public class GuiElement{
	public final Vector2f position;
	public final Image image;
	public GuiElement(Vector2f position, Image image) {
		super();
		this.position = position;
		this.image = image;
	}
	public GuiElement(Vector2f position, String ref) {
		this(position, Loader.loadImage(ref));
	}
	public GuiElement(float x, float y, Image image) {
		super();
		this.position = new Vector2f(x,y);
		this.image = image;
	}
	public GuiElement(float x, float y, String ref) {
		this(new Vector2f(x,y), Loader.loadImage(ref));
	}
	public GuiElement(String ref) {
		this(new Vector2f(), Loader.loadImage(ref));
	}
	
	public void render(float x, float y, Graphics g) {
		image.drawCentered(position.x + x, position.y + y);
	}
	public void render(Vector2f v, Graphics g) {
		render(v.x, v.y, g);
	}
	public void render(Graphics g) {
		render(0,0,g);
	}
	
	
}
