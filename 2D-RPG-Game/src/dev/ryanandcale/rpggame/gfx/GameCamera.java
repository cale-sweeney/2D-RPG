package dev.ryanandcale.rpggame.gfx;

import dev.ryanandcale.rpggame.Game;
import dev.ryanandcale.rpggame.Handler;
import dev.ryanandcale.rpggame.entities.Entity;
import dev.ryanandcale.rpggame.tiles.Tile;

public class GameCamera {

	private Handler handler;
	private float xOffset, yOffset;
	
	
	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset; //x position of game camera
		this.yOffset = yOffset; //y position of game camera

	}
	
	//check for blank space at the edge of the map
	//if its there, don't show it
	public void checkBlankSpace(){
		if(xOffset < 0){
			xOffset = 0;
		}else if(xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()){
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}
		
		if(yOffset < 0){
			yOffset = 0;
		}else if(yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()){
			yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
			
		}

		//My code, why did it not work?  I used Game width and height instead of the world width and height.
		/*		if(xOffset > handler.getGame().getWidth() + Tile.TILEWIDTH){
			xOffset = handler.getGame().getWidth() - Tile.TILEWIDTH * 2;
		}
		if(yOffset > handler.getGame().getHeight() + Tile.TILEHEIGHT){
			yOffset = handler.getGame().getHeight() - Tile.TILEHEIGHT * 2;
		}*/
	}
	
	//keep the game camera focused on the player hero
	public void centerOnEntity(Entity e){
		
		//player's position minus game screen width divide by 2 to center
		//also take into account player's size with e.getWidth()
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2; 
		 
		//player's position minus game screen height divide by 2 to center
		//also take into account the player's size with e.getHeight()
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
		
		//Check for blank space at the edge of the map and remove it
		checkBlankSpace();
		
	}
	
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
		
	}


	public float getxOffset() {
		return xOffset;
	}


	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}


	public float getyOffset() {
		return yOffset;
	}


	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
