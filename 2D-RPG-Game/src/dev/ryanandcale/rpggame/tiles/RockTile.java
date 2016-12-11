package dev.ryanandcale.rpggame.tiles;

import dev.ryanandcale.rpggame.gfx.Assets;

public class RockTile extends Tile{

	public RockTile(int id) {
		super(Assets.rock, id);
	}
	
	//override the isSolid method in the parent tile class
	@Override //Notation lets you know it overrides the parent class
	public boolean isSolid(){
		return true;
	}
	
}
