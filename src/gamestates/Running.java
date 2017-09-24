package gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import entities.SnakeHead;

public class Running extends BasicGameState{

	Input input;

	SnakeHead sh = new SnakeHead();
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		input = new Input(Input.ANY_CONTROLLER);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		sh.draw(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		sh.update(input, delta);	
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return States.running;
	}

}
