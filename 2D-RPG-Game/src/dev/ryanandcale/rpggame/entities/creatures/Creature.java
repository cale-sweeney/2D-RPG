package dev.ryanandcale.rpggame.entities.creatures;

import dev.ryanandcale.rpggame.Handler;
import dev.ryanandcale.rpggame.entities.Entity;
import dev.ryanandcale.rpggame.tiles.Tile;

public abstract class Creature extends Entity {

	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64; //might need to be 100
	public static final int DEFAULT_CREATURE_HEIGHT = 64; //might need to be 100
	
	protected float speed;
	protected float xMove, yMove;
	protected boolean attack;
	
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height); //passes the x, y, width, height along to the Entity class
		speed = DEFAULT_SPEED;
		xMove = 0;  //x-coordinate on the screen of the creature
		yMove = 0; //y-coordinate on the screen of the creature
		attack = false;
		
	}

	//We have not changed our X or Y position yet, 
	//so we have to use the offset to tell the collision box
	//where we are moving to
	public void move(){
		//Do not move if you are running into something or attacking
		if(!checkEntityCollisions(xMove, 0f) && (!attack ))
			moveX();
		if(!checkEntityCollisions(0f, yMove)  && (!attack))
			moveY();
		
	}
	
	//move the creature left and right
	public void moveX(){
		if(xMove > 0){ //Moving right
			
			//what ever tile we are trying to move into, if it is not solid, we are good to move
			int tx = (int)( x + xMove + physicalBounds.x + physicalBounds.width) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + physicalBounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + physicalBounds.y + physicalBounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else{ //there was a collision
				//allows are player to stand flush against a tile 
				//there will be a few pixels of gap without this code
				//-1 allows us to move up and down while flush, creating 1 pixel of space
				x = tx * Tile.TILEWIDTH - physicalBounds.x - physicalBounds.width -1; 
				
			}
			
			
		}else if(xMove < 0){ //moving left
			
			int tx = (int)( x + xMove + physicalBounds.x) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + physicalBounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + physicalBounds.y + physicalBounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				//allows player to move flush with solid objects
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - physicalBounds.x;
			}
			
		}
	}
	
	//move the creature up and down
	public void moveY(){
		if(yMove < 0){ //Moving up
			int ty = (int) (y + yMove + physicalBounds.y) / Tile.TILEHEIGHT; //top portion of our bounding rectangle
			
			if(!collisionWithTile((int) (x + physicalBounds.x) /Tile.TILEWIDTH, ty ) &&  //upper lefthand corner of the bounding rectangle
					!collisionWithTile((int) (x + physicalBounds.x + physicalBounds.width) /Tile.TILEWIDTH, ty )){
				y += yMove;
			} else { //there was a collision, allow the player to be flush with solid object
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - physicalBounds.y;
			}
			
		}else if (yMove > 0){ //Moving down
			int ty = (int) (y + yMove + physicalBounds.y + physicalBounds.height) / Tile.TILEHEIGHT; //lower portion of our bounding rectangle
			
			if(!collisionWithTile((int) (x + physicalBounds.x) /Tile.TILEWIDTH, ty ) &&
					!collisionWithTile((int) (x + physicalBounds.x + physicalBounds.width) /Tile.TILEWIDTH, ty )){
				y += yMove;
			} else { //there was a collision, allow the player to be flush with the solid object
				y = ty * Tile.TILEHEIGHT - physicalBounds.y - physicalBounds.height - 1; //-1 to allow sliding will flush with a solid object
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
