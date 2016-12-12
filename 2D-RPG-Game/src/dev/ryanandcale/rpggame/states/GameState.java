package dev.ryanandcale.rpggame.states;

import java.awt.Graphics;

import dev.ryanandcale.rpggame.Game;
import dev.ryanandcale.rpggame.Handler;
import dev.ryanandcale.rpggame.entities.creatures.Player;
import dev.ryanandcale.rpggame.gfx.Assets;
import dev.ryanandcale.rpggame.tiles.Tile;
import dev.ryanandcale.rpggame.worlds.World;

public class GameState extends State{

	private Player player;
	private World world;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		player = new Player(handler,100,100);
		
		
		//game.getGameCamera().move(100, 200); //controls where the game camera starts
	}
	
	@Override
	public void tick() {
		world.tick();
		player.tick();
		
		
		
		//game.getGameCamera().move(1, 1);//float the game camera slowly diagonally.
		
	}

	@Override
	public void render(Graphics g) {
		//g.drawImage(Assets.dirt, 0, 0, null);
		//Tile.tiles[0].render(g, 0, 0);   //we can access this because its public and static
		world.render(g);
		player.render(g);

	}
	
	

}
