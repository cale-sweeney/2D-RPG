package dev.ryanandcale.rpggame.states;

import java.awt.Graphics;

import dev.ryanandcale.rpggame.Game;
import dev.ryanandcale.rpggame.entities.creatures.Player;
import dev.ryanandcale.rpggame.gfx.Assets;
import dev.ryanandcale.rpggame.tiles.Tile;
import dev.ryanandcale.rpggame.worlds.World;

public class GameState extends State{

	private Player player;
	private World world;
	
	public GameState(Game game){
		super(game);
		player = new Player(game,100,100);
		world = new World("res/worlds/world1.txt");
	}
	
	@Override
	public void tick() {
		world.tick();
		player.tick();
		
	}

	@Override
	public void render(Graphics g) {
		//g.drawImage(Assets.dirt, 0, 0, null);
		//Tile.tiles[0].render(g, 0, 0);   //we can access this because its public and static
		world.render(g);
		player.render(g);

	}
	
	

}
