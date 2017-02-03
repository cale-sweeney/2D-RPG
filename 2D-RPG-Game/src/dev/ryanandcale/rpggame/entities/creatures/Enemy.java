/**
 * 
 */
package dev.ryanandcale.rpggame.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.ryanandcale.rpggame.Handler;
import dev.ryanandcale.rpggame.entities.Entity;

/**
 * @author csweeney
 *
 */
public abstract class Enemy extends Creature {

	protected int enemyAwarenessRange;
	protected Rectangle awarenessBounds;

	public Enemy(Handler handler, float x, float y, int width, int height, int enemyAwarenessRange) {
		super(handler, x, y, width, height);
		
		awarenessBounds = new Rectangle(0, 0, enemyAwarenessRange, enemyAwarenessRange);
	}


	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void die() {
		// TODO Auto-generated method stub

	}
	
	//Checks to see if the enemy detects the player
	public boolean enemyLooksForPlayer(){
		int playersX = (int) handler.getWorld().getEntityManager().getPlayer().getX();
		int playersY = (int) handler.getWorld().getEntityManager().getPlayer().getY();
		
		System.out.println("Werewolf sees player's X at: " + playersX + " and Y at: " + playersY);
		
		//implement awareness range logic
		
		return true;
		
	}

}
