package dev.ryanandcale.rpggame.entities.statics;

import java.awt.Graphics;

import dev.ryanandcale.rpggame.Handler;
import dev.ryanandcale.rpggame.gfx.Assets;
import dev.ryanandcale.rpggame.items.Item;
import dev.ryanandcale.rpggame.tiles.Tile;

public class Tree extends StaticEntity {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
		
		physicalBounds.x = 10;
		physicalBounds.y = (int) (height / 1.5f);
		physicalBounds.width = width - 20;
		physicalBounds.height = (int)(height - height / 1.5f);
	}

	@Override
	public void tick() {
	
		
	}
	
	@Override
	public void die(){
		handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int) x, (int) y));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}
	
	

}
