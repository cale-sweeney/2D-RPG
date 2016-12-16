package dev.ryanandcale.rpggame.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import dev.ryanandcale.rpggame.Handler;
import dev.ryanandcale.rpggame.entities.creatures.Player;

public class EntityManager {

	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>(){	
		@Override
		public int compare(Entity a, Entity b){			
			//check the bottom of the y coordinate of our entities (e.g. foot of the tree and foot of the player)
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight())  
				return -1; //b should be rendered after a
			return 1; //a should be rendered after b
		}
	};	
	
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>(); //ArrayList allows you to add and remove as many entities as you want to.  No resizing necessity.
		addEntity(player); //add your player to the entity array
	}
	
	public void tick(){
		for(int i = 0; i < entities.size(); i++){
			Entity e = entities.get(i);
			e.tick();
		}
		entities.sort(renderSorter);
	}
	
	public void render(Graphics g){
		for(Entity e : entities){
			e.render(g);
		}
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
