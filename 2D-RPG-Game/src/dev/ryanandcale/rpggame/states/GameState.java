package dev.ryanandcale.rpggame.states;

import java.awt.Graphics;

import dev.ryanandcale.rpggame.Game;
import dev.ryanandcale.rpggame.entities.creatures.Player;
import dev.ryanandcale.rpggame.gfx.Assets;
import dev.ryanandcale.rpggame.tiles.Tile;

public class GameState extends State{

	private Player player;
	
	public GameState(Game game){
		super(game);
		player = new Player(game,100,100);
	}
	
	@Override
	public void tick() {
		player.tick();
		
	}

	@Override
	public void render(Graphics g) {
		//g.drawImage(Assets.dirt, 0, 0, null);
		Tile.tiles[0].render(g, 0, 0);   //we can access this because its public and static
		player.render(g);

	}
	
	

}
