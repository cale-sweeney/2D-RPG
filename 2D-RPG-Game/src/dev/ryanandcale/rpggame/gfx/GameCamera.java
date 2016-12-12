package dev.ryanandcale.rpggame.gfx;

import dev.ryanandcale.rpggame.Game;
import dev.ryanandcale.rpggame.entities.Entity;

public class GameCamera {

	private Game game;
	private float xOffset, yOffset;
	
	
	public GameCamera(Game game, float xOffset, float yOffset) {
		this.game = game;
		this.xOffset = xOffset; //x position of game camera
		this.yOffset = yOffset; //y position of game camera

	}
	
	//keep the game camera focused on the player hero
	public void centerOnEntity(Entity e){
		//player's position minus game screen width divide by 2 to center
		//also take into account player's size with e.getWidth()
		xOffset = e.getX() - game.getWidth() / 2 + e.getWidth() / 2; 
		 //player's position minus game screen height divide by 2 to center
		//also take into accoun the player's size with e.getHeight()
		yOffset = e.getY() - game.getHeight() / 2 + e.getHeight() / 2;
	}
	
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
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
