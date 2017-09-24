package gamestates;


import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import gui.Panel;

public class Menu extends BasicGameState{

	Font font;
	Panel main;
	
	TextField Ipcreate, Ipjoin;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		States.stateMenu = this;
		
		font = new UnicodeFont(new java.awt.Font("Arial", java.awt.Font.ITALIC, 26));
		
		Ipcreate = new TextField(gc, font, 100, 500, 100, 100);
		Ipjoin = new TextField(gc, font, 600, 500, 100, 100);
		Ipcreate.setBackgroundColor(Color.blue);
		Ipjoin.setBackgroundColor(Color.blue);
		Ipcreate.setText("Create Server");
		Ipjoin.setText("join Server");

		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		Ipcreate.render(gc, g);
		Ipjoin.render(gc, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
	}

	
	
	@Override
	public int getID() {
		return States.menu;
	}

}
