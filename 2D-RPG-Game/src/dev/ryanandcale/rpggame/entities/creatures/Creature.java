package dev.ryanandcale.rpggame.entities.creatures;

import dev.ryanandcale.rpggame.entities.Entity;

public abstract class Creature extends Entity {

	protected int health;
	
	public Creature(float x, float y) {
		super(x, y); //passes the x and y along to the Entity class
		health = 10;
	}

	
}
