package dev.ryanandcale.rpggame.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.ryanandcale.rpggame.Game;
import dev.ryanandcale.rpggame.Handler;

public class MenuState extends State{
	
	public MenuState(Handler handler){
		super(handler);
	}

	@Override
	public void tick() {
		//System.out.println(handler.getMouseManager().getMouseX() + "   " + handler.getMouseManager().getMouseY());
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed()){
			State.setState(handler.getGame().gameState);
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);
		
	}
	

}
