package gui;

import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.TextField;

import tools.Vector2f;

public class InputField extends TextField implements GuiElement{
	
	private Vector2f position;
	private String startMessage;
	
	public InputField(String startMessage ,int x, int y, int width, int height, Font font, GUIContext container) {
		super(container, font, x, y, width, height);
		position = new Vector2f(x,y);
		setText(startMessage);
		this.startMessage = startMessage;
	}
	
	
	
	@Override
	public void render(float x, float y, Graphics g) {
		this.x = (int) (x+position.x);
		this.y = (int) (y+position.y);
		render(container, g);
	}

	@Override
	public void render(Vector2f v, Graphics g) {
		render(v.x,v.y,g);
	}

	@Override
	public Vector2f getPosition() {
		return position;
	}

	@Override
	public void setPosition(float x, float y) {
		position.set(x, y);
	}
	public void setPosition(Vector2f v) {
		position.set(v.x, v.y);
	}

	@Override
	public Image getImage() {
		return null;
	}



	@Override
	public void update(int delta) {
		if (getText().equals(startMessage) && hasFocus()) {
			setText("");
		}else if(getText().equals("") && !hasFocus()) {
			setText(startMessage);
		}
	}

}
