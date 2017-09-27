package entities;

import org.newdawn.slick.Graphics;

import tools.Vector2f;

public class SnakeSegment 
{
	public Vector2f position = new Vector2f();
	public Vector2f leadingPartPosition;
	public float size = 20;
	public boolean follow = true;
	public Vector2f explodeVelocity = new Vector2f();
	
	public SnakeSegment(float size)
	{
		
		this.size = size;
		explodeVelocity.x = (float) (Math.random() - 0.5f);
		explodeVelocity.y = (float) (Math.random() - 0.5f);
	}
	
	public void draw(Graphics g)
	{
		g.fillOval(position.x, position.y + 720, size, size);
	}
	
	public void update(int deltaTime)
	{
		if (leadingPartPosition != null && follow)
		{
			position.set(
					leadingPartPosition.copy().add(
					position.copy().sub(leadingPartPosition.copy()).normalise().scale(size)));
		}
		
		if (!follow)
		{
			explode(deltaTime);
		}
	}
	
	private void explode(int deltaTime) 
	{
		if (size > 0)
		{
			position.x += explodeVelocity.x * ((float)deltaTime) / 10;
			position.y += explodeVelocity.y * ((float)deltaTime) / 10;
			size -= Math.random() * 0.1;
		}
		else
		{
			size = 0;
		}
	}
}
