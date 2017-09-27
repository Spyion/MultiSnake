package gamestates;


import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import gui.InputField;
import gui.Panel;

public class Menu extends BasicGameState{
	
	Font font;
	Panel main;
	
	InputField Ipcreate, Ipjoin;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		States.stateMenu = this;
		
//		font = new UnicodeFont(new java.awt.Font("Arial", java.awt.Font.ITALIC, 26));
		font = gc.getDefaultFont();
		
		
		
		Ipcreate = 	new InputField("CREATE  IP:PORT", 100, 500, 250, 20, font, gc);
		Ipjoin = 	new InputField("JOIN  IP:PORT", 600, 500, 250, 20, font, gc);
		Ipcreate.setBackgroundColor(Color.black);
		Ipjoin.setBackgroundColor(Color.black);
		
		main = new Panel(0, 0, Ipcreate, Ipjoin);

		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {		
		main.render(g);
		g.setBackground(Color.white);
	}

	float count = 0;
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		main.update(delta);
	}

	
	
	@Override
	public int getID() {
		return States.menu;
	}

}
