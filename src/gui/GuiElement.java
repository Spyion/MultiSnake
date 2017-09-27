package gui;


import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import tools.Vector2f;

public interface GuiElement{
	
	public void render(float x, float y, Graphics g);
	public void render(Vector2f v, Graphics g);
	public Vector2f getPosition();
	public void setPosition(float x, float y);
	public void setPosition(Vector2f v);
	public Image getImage();
	
	public void update(int delta);
	
	
}
