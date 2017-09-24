package gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import entities.SimulatedSnake;

public class Running extends BasicGameState{
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
	}
	
	public SimulatedSnake getSnakeByID(int ID) {
		return null;
	}
	public void addSnake(SimulatedSnake s) {
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return States.running;
	}

}
