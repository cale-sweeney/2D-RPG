package dev.ryanandcale.rpggame.entities.creatures;

import java.awt.Graphics;

import dev.ryanandcale.rpggame.Game;
import dev.ryanandcale.rpggame.gfx.Assets;

public class Player extends Creature{
	
	public Player(Game game, float x, float y) {
		super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
	}

	@Override
	public void tick() {
		getInput();
		move();
		game.getGameCamera().centerOnEntity(this); //center the camera on this player after he moves

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
		
		if (game.getKeyManager().up)
			yMove = -speed; //up the y-axis
		if(game.getKeyManager().down)
			yMove = speed;
		if(game.getKeyManager().left)
			xMove = -speed;
		if(game.getKeyManager().right)
			xMove = speed;
	}
	

	@Override
	public void render(Graphics g) {
		//width and height parameters determine the size of the final size of the player on the screen
		//x and y determine the 
		g.drawImage(Assets.player, (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), width, height, null);
		
	}

}
