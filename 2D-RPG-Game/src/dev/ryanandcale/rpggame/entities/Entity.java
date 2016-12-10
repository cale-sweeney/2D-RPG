package dev.ryanandcale.rpggame.entities;

import java.awt.Graphics;

public abstract class Entity {
	
	//private variable, but classes that extend this class also has access
	protected float x, y;
	
	public Entity(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
