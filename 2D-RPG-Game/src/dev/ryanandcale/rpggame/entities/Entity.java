package dev.ryanandcale.rpggame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.ryanandcale.rpggame.Game;
import dev.ryanandcale.rpggame.Handler;

public abstract class Entity {
	
	//private variable, but classes that extend this class also has access
	public static final int DEFAULT_HEALTH = 10;
	protected Handler handler;
	protected float x, y;
	protected int width, height; //size of the entity
	protected int health;
	protected boolean active = true;
	protected Rectangle bounds;
	
	public Entity(Handler handler, float x, float y, int width, int height){
		this.handler = handler;
		this.x = x; //entity's x position on the screen
		this.y = y; //entity's y position on the screen
		this.width = width;
		this.height = height;
		health = DEFAULT_HEALTH;
		
		bounds = new Rectangle(0, 0, width, height); //for collision detection
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void die();
	
	public void hurt(int amt){
		health -= amt;
		if(health <= 0){
			active = false;
			die();
		}
	}
	
	//this method tests every entity in our game and sees if it collides with another
	public boolean checkEntityCollisions(float xOffset, float yOffset){
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this)) //don't check collisions with yourself
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) //if it intersects our collision bounds
				return true;
		}
		return false;
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		//x is the position of the entity
		//plus the bounding box xoffset of the entity or bounds.x
		//same for y
		//then the width of the bounding box and the height of the bounding box bounds.width and bounds.height
		return new Rectangle((int)(x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}

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

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
