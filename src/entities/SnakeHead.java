package entities;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import tools.Vector2f;

public class SnakeHead 
{
	public float moveSpeed = 4;
	public float size = 5;
		
	public Vector2f position = new Vector2f();
	public Vector2f targetPosition = new Vector2f();
	
	int numberOfSegments;
	int desiredNumberOfSegments = 500;
	
	boolean alive = true;
	
	public int id;
	
	List<SnakeSegment> mySegments = new ArrayList<SnakeSegment>();
		
	public SnakeHead()
	{
		this.id = 0;
	}
	
	public SnakeHead(int id) 
	{
		this.id = id;
	}
	
	public void draw(Graphics g)
	{
		g.fillOval(position.x, position.y + 720, size, size);
		
		for (int i = 0; i < mySegments.size(); i++) 
		{
			mySegments.get(i).draw(g);
		}
	}
	
	public void update(Input input, int deltaTime)
	{
		targetPosition.x = input.getMouseX();		
		targetPosition.y = input.getMouseY();
		
		position.set(position.copy().add(targetPosition.copy().sub(position).normalise().scale(Math.min(1, targetPosition.copy().sub(position).length() / 20) * moveSpeed * (float)deltaTime / 10f)));
		
		if (desiredNumberOfSegments > numberOfSegments)
		{
			numberOfSegments += 1;
			SnakeSegment newSS = new SnakeSegment(size);
			
			if (mySegments.size() != 0)
			{
				newSS.leadingPartPosition = mySegments.get(mySegments.size() - 1).position;
			}
			else
			{
				newSS.leadingPartPosition = position;
			}
			mySegments.add(newSS);
			
			//updateSegmentSizes();
		}
		
		for (int i = 0; i < mySegments.size(); i++) 
		{
			mySegments.get(i).update(deltaTime);
		}
		
		checkIfSelfColliding();
		
		if (!alive)
		{
			System.out.println("DEAD");
			explode();
		}
	}
	
	public void updateSegmentSizes()
	{
		for (int i = 0; i < mySegments.size(); i++) 
		{
			mySegments.get(i).size = mySegments.size();
		}
	}
	
	public void checkIfSelfColliding()
	{
		for (int i = 2; i < mySegments.size(); i++) 
		{
			if ((mySegments.get(i).position.copy().sub(position)).length() < mySegments.get(i).size + size)
			{
				alive = false;
			}
		}
	}
	
	public void explode()
	{
		for (int i = 0; i < mySegments.size(); i++) 
		{
			mySegments.get(i).follow = false;
		}
	}
		
	public SnakeData getSnakeData()
	{
		float[] xPositions = new float[mySegments.size() + 1];
		float[] yPositions = new float[mySegments.size() + 1];
		float[] sizes = new float[mySegments.size() + 1];
		
		xPositions[0] = position.x;
		yPositions[0] = position.y;
		sizes[0] = size;
		
		for (int i = 1; i < mySegments.size() + 1; i++) 
		{			
			xPositions[i] = mySegments.get(i).position.x;
			yPositions[i] = mySegments.get(i).position.y;
			sizes[i] = mySegments.get(i).size;
		}
		
		SnakeData rVal = new SnakeData(xPositions, yPositions, sizes);
		
		return rVal;		
	}
}
