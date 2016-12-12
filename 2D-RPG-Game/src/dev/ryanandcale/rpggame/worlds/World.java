package dev.ryanandcale.rpggame.worlds;

import java.awt.Graphics;

import dev.ryanandcale.rpggame.tiles.Tile;
import dev.ryanandcale.rpggame.utils.Utils;

public class World {
	
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles; //integer multi-dimensional array

	public World(String path) {
		loadWorld(path);
	}

	//to update all the positions of tiles
	public void tick(){
		
	}
	
	public void render(Graphics g){
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				getTile(x,y).render(g, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT);
			}
		}
	}
	
	public Tile getTile(int x, int y){
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.dirtTile;
		return t;
		
	}
	
	//Get the data and store it in the multi-dimensional tile array
	private void loadWorld(String path){
		
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+"); //split on any amount of whitespace, so a space character or a newline character
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);  //adding 4 for the first four variables above
			}
		}
		
		//Old-style simple world creation
/*		//my 5x5 world
		width = 5;
		height = 5;
		tiles = new int[width][height];
		
		//loop thru every element in tiles array and set it
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				tiles[x][y] = 1;
			}
		}*/
		
	}
	
	
}
