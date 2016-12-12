package dev.ryanandcale.rpggame.entities.creatures;

import dev.ryanandcale.rpggame.Game;
import dev.ryanandcale.rpggame.Handler;
import dev.ryanandcale.rpggame.entities.Entity;
import dev.ryanandcale.rpggame.tiles.Tile;

public abstract class Creature extends Entity {

	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64; //might need to be 100
	public static final int DEFAULT_CREATURE_HEIGHT = 64; //might need to be 100
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;
	
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height); //passes the x, y, width, height along to the Entity class
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;  //x-coordinate on the screen of the creature
		yMove = 0; //y-coordinate on the screen of the creature
	}

	public void move(){
		moveX();
		moveY();
		
	}
	
	//move the creature left and right
	public void moveX(){
		if(xMove > 0){ //Moving right
			
			//what ever tile we are trying to move into, if it is not solid, we are good to move
			int tx = (int)( x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}
			
			
		}else if(xMove < 0){ //moving left
			
			int tx = (int)( x + xMove + bounds.x) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}
			
		}
	}
	
	//move the creature up and down
	public void moveY(){
		if(yMove < 0){ //Moving up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT; //top portion of our bounding rectangle
			
			if(!collisionWithTile((int) (x + bounds.x) /Tile.TILEWIDTH, ty ) &&  //upper lefthand corner of the bounding rectangle
					!collisionWithTile((int) (x + bounds.x + bounds.width) /Tile.TILEWIDTH, ty )){
				y += yMove;
			} 
			
		}else if (yMove > 0){ //Moving down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT; //lower portion of our bounding rectangle
			
			if(!collisionWithTile((int) (x + bounds.x) /Tile.TILEWIDTH, ty ) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) /Tile.TILEWIDTH, ty )){
				y += yMove;
			} 
			
		}
	}
	
	protected boolean collisionWithTile(int x, int y){
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	//GETTERS & SETTERS

	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public float getSpeed() {
		return speed;
	}


	public void setSpeed(float speed) {
		this.speed = speed;
	}


	public float getxMove() {
		return xMove;
	}


	public void setxMove(float xMove) {
		this.xMove = xMove;
	}


	public float getyMove() {
		return yMove;
	}


	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	
}
