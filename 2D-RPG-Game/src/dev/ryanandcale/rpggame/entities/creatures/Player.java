package dev.ryanandcale.rpggame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import dev.ryanandcale.rpggame.Game;
import dev.ryanandcale.rpggame.Handler;
import dev.ryanandcale.rpggame.gfx.Assets;

public class Player extends Creature{
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		//boundary collision
		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 32;
	}

	@Override
	public void tick() {
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this); //center the camera on this player after he moves

		//old-style of moving, now in getInput()
/*		if(game.getKeyManager().up)
			y -= 3;
		if(game.getKeyManager().down)
			y += 3;
		if(game.getKeyManager().left)
			x -= 3;
		if(game.getKeyManager().right)
			x += 3;*/
		
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if (handler.getKeyManager().up)
			yMove = -speed; //up the y-axis
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}
	

	@Override
	public void render(Graphics g) {
		//width and height parameters determine the size of the final size of the player on the screen
		//x and y determine the 
		g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		//boundary collision box
		g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
				bounds.width, bounds.height);
		
	}

}
