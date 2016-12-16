package dev.ryanandcale.rpggame.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import dev.ryanandcale.rpggame.Handler;
import dev.ryanandcale.rpggame.entities.creatures.Player;

public class EntityManager {

	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>(); //ArrayList allows you to add and remove as many entities as you want to.  No resizing necessity.
		
	}
	
	public void tick(){
		for(int i = 0; i < entities.size(); i++){
			Entity e = entities.get(i);
			e.tick();
		}
		player.tick();
	}
	
	public void render(Graphics g){
		for(Entity e : entities){
			e.render(g);
		}
		player.render(g);
	}

	public void addEntity(Entity e){
		entities.add(e);
	}
	
	//GETTER & SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	


	
}
