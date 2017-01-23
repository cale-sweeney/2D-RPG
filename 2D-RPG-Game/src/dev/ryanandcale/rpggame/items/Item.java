package dev.ryanandcale.rpggame.items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.ryanandcale.rpggame.Handler;
import dev.ryanandcale.rpggame.gfx.Assets;

public class Item {
	
	//Handler
	public static Item[] items = new Item[256];
	public static Item woodItem = new Item(Assets.wood, "Wood", 0);
	public static Item stoneItem = new Item(Assets.stone, "Stone", 1);
			
	
	//Class
	
	//the size that items are rendered at in the game
	public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32, PICKED_UP = -1;
	protected Handler handler;
	protected BufferedImage texture;
	protected String name; //name of the item
	protected final int id; //id of the item
	
	protected int x, y, count; //count stores the amount of an item, like 50 wood
							   //if count becomes -1, add to player's inventory
	

	public Item(BufferedImage texture, String name, int id) {
		this.texture = texture;
		this.name = name;
		this.id = id;
		count = 1;

		items[id] = this;
	}
	
	public void tick(){
		
	}
	
	//if the item is being displayed in the game world
	public void render(Graphics g){
		if (handler == null){
			return;
		}
		render(g,(int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()));
	}
	
	//If the item is being displayed in an inventory
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
	}
	
	public Item createNew(int x, int y){
		Item i = new Item(texture, name, id);
		i.setPosition(x,y);
		return i;
		
	}

	
	public void setPosition(int x , int y ){
		this.x = x;
		this.y = y;
	}
	
	//GETTERS and SETTERS 
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}
	

}
