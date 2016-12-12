package dev.ryanandcale.rpggame.entities;

import java.awt.Graphics;

import dev.ryanandcale.rpggame.Game;

public abstract class Entity {
	
	//private variable, but classes that extend this class also has access
	protected Game game;
	protected float x, y;
	protected int width, height; //size of the entity
	
	public Entity(Game game, float x, float y, int width, int height){
		this.game = game;
		this.x = x; //entity's x position on the screen
		this.y = y; //entity's y position on the screen
		this.width = width;
		this.height = height;
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
