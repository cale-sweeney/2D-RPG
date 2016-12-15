package dev.ryanandcale.rpggame.worlds;

import java.awt.Graphics;

import dev.ryanandcale.rpggame.Game;
import dev.ryanandcale.rpggame.Handler;
import dev.ryanandcale.rpggame.tiles.Tile;
import dev.ryanandcale.rpggame.utils.Utils;

public class World {
	
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles; //integer multi-dimensional array

	//World object takes in a Game object and path to the world text file
	public World(Handler handler, String path) {
		this.handler = handler;
		loadWorld(path);
	}

	//to update all the positions of tiles
	public void tick(){
		
	}
	
	public void render(Graphics g){
		
		//These four calculations are asking: Is zero greater than our game camera's offset?
		//The goal is to reduce the amount of rendering that is done to only what the user can see.
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH); //don't want this to go negative, hence using max
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y++){ ////tiles from the top of the user's view to the tile on the bottom of the user's view
			for(int x = xStart; x < xEnd; x++){ //tiles from the far left of the user's view to the tile on the far right of the user's view
				getTile(x,y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), 
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}
	
	public Tile getTile(int x, int y){
		
		//if we are out of bounds of the map
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
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

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	
}
