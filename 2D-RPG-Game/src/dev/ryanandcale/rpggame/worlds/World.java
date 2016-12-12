package dev.ryanandcale.rpggame.worlds;

import java.awt.Graphics;

import dev.ryanandcale.rpggame.Game;
import dev.ryanandcale.rpggame.tiles.Tile;
import dev.ryanandcale.rpggame.utils.Utils;

public class World {
	
	private Game game;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles; //integer multi-dimensional array

	//World object takes in a Game object and path to the world text file
	public World(Game game, String path) {
		this.game = game;
		loadWorld(path);
	}

	//to update all the positions of tiles
	public void tick(){
		
	}
	
	public void render(Graphics g){
		
		//These four calculations are asking: Is zero greater than our game camera's offset?
		//The goal is to reduce the amount of rendering that is done to only what the user can see.
		int xStart = (int) Math.max(0, game.getGameCamera().getxOffset() / Tile.TILEWIDTH); //don't want this to go negative, hence using max
		int xEnd = (int) Math.min(width, (game.getGameCamera().getxOffset() + game.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, game.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (game.getGameCamera().getyOffset() + game.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y++){ ////tiles from the top of the user's view to the tile on the bottom of the user's view
			for(int x = xStart; x < xEnd; x++){ //tiles from the far left of the user's view to the tile on the far right of the user's view
				getTile(x,y).render(g, (int) (x * Tile.TILEWIDTH - game.getGameCamera().getxOffset()), 
						(int) (y * Tile.TILEHEIGHT - game.getGameCamera().getyOffset()));
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
