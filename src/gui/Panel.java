package gui;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.gui.TextField;

public class Panel {
	
	private final Vector2f position = new Vector2f();
	private final ArrayList<GuiElement> elements = new ArrayList<GuiElement>();
	private final ArrayList<TextField> textFields = new ArrayList<TextField>();
	
	public Panel(float x, float y, Object ...elements) {
		position.set(x, y);
		for(Object e : elements) {
			add(e);
		}
	}
	
	public void render(Graphics g) {
		for(GuiElement e : elements) {
			e.render(position, g);
		}
		for(TextField t : textFields) {
			t.render(null, g);
		}
	}
	public void update() {
	}
	
	public void add(Object e) {
		if(e instanceof GuiElement) {
			elements.add((GuiElement)e);
		}else if(e instanceof TextField) {
			textFields.add((TextField)e);
		}
	}
	
}
