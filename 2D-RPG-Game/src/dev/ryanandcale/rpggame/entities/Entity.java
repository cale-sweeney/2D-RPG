package dev.ryanandcale.rpggame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.ryanandcale.rpggame.Game;
import dev.ryanandcale.rpggame.Handler;

public abstract class Entity {
	
	//private variable, but classes that extend this class also has access
	protected Handler handler;
	protected float x, y;
	protected int width, height; //size of the entity
	protected Rectangle bounds;
	
	public Entity(Handler handler, float x, float y, int width, int height){
		this.handler = handler;
		this.x = x; //entity's x position on the screen
		this.y = y; //entity's y position on the screen
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(0, 0, width, height); //for collision detection
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
}
