package dev.ryanandcale.rpggame.states;

import java.awt.Graphics;

import dev.ryanandcale.rpggame.Game;
import dev.ryanandcale.rpggame.Handler;

public abstract class State {

	private static State currentState = null;
	
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
	
	//CLASS
	
	protected Handler handler;
	
	public State(Handler handler){
		this.handler = handler;
	}
	
	public abstract void tick();
	
	//So the the state can draw to the screen directly
	public abstract void render(Graphics g);
	
}
