package dev.ryanandcale.rpggame.entities.statics;

import java.awt.Graphics;

import dev.ryanandcale.rpggame.Handler;
import dev.ryanandcale.rpggame.gfx.Assets;
import dev.ryanandcale.rpggame.tiles.Tile;

public class Tree extends StaticEntity {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}
	
	

}
