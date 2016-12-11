package dev.ryanandcale.rpggame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//STATIC VARIABLES (Accessible from anywhere)
	public static Tile[] tiles = new Tile[256]; //the tiles array holds the ids
	public static Tile grassTile = new GrassTile(0);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile rockTile = new RockTile(2);
	
	
	//CLASS

	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture; //protected because we will extend this tile class with other classes
	protected final int id; //its final since we should never have to change the tile id once assigned
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this; //the tiles constructor is assigning the tiles above to its own array
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y,TILEWIDTH,TILEHEIGHT, null);
	}
	
	//are you allowed to walk through the tile?
	public boolean isSolid(){
		return false;
	}
	
	public int getId(){
		return id;
	}

}
