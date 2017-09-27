package gui;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

import tools.Vector2f;

public class Panel {
	
	private final Vector2f position = new Vector2f();
	private final Vector2f targetPosition = new Vector2f();
	private final ArrayList<GuiElement> elements = new ArrayList<GuiElement>();
	
	
	public BlendMode blendMode = BlendMode.None;
	
	private int time = 0;
	private int endTime;
	
	public enum BlendMode{
		None, Linear, Quadratic, Cubic;
	}
	
	public Panel(float x, float y, GuiElement ...elements) {
		position.set(x, y);
		targetPosition.set(x, y);
		for(GuiElement e : elements) {
			add(e);
		}
	}
	
	public void render(Graphics g) {
		for(GuiElement e : elements) {
			e.render(position, g);
		}
	}
	public void update(int delta) {
		for(GuiElement e : elements) {
			e.update(delta);
		}
		
		if(blendMode == BlendMode.Cubic) {
			
		}else if(blendMode == BlendMode.Quadratic) {

		}else if(blendMode == BlendMode.Linear) {
			
		}else if(blendMode == BlendMode.None) {
			position.set(targetPosition);
		}
		
	}
	
	public void move(Vector2f target, int ms) {
		targetPosition.set(target);
		time = 0;
		endTime = ms;
	}
	
	public Panel add(GuiElement ...es) {
		for(GuiElement e : es)
			elements.add(e);
		return this;
	}
	public <T extends Iterable<GuiElement>> Panel add(T t) {
		for(GuiElement e : t)
			elements.add(e);
		return this;
	}

	public BlendMode getBlendMode() {
		return blendMode;
	}
	public Vector2f getPosition() {
		return position;
	}

	public Panel setBlendMode(BlendMode blendMode) {
		this.blendMode = blendMode;
		return this;
	}
	
	
	
}
