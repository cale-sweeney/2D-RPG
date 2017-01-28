package dev.ryanandcale.rpggame.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.ryanandcale.rpggame.Handler;
import dev.ryanandcale.rpggame.entities.Entity;
import dev.ryanandcale.rpggame.gfx.Animation;
import dev.ryanandcale.rpggame.gfx.Assets;
import dev.ryanandcale.rpggame.inventory.Inventory;

public class Player extends Creature{
	
	//Movement Animations
	private Animation animDown, animUp, animLeft, animRight;
	//Attack Animations
	private Animation animPunchLeft, animPunchRight;
	
	//Attack timer
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
	//Player Inventory
	private Inventory inventory;
	
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		//boundary collision
		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 32;
		
		animDown = new Animation(500, Assets.player_down);
		animUp = new Animation(500, Assets.player_up);
		animLeft = new Animation(500, Assets.player_left);
		animRight = new Animation(500, Assets.player_right);
		
		animPunchLeft = new Animation(500, Assets.player_punch_left);
		animPunchRight = new Animation(500, Assets.player_punch_right);
		
		inventory = new Inventory(handler);
	}

	@Override
	public void tick() {
		//Movement Animations
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		
		//Attack Animations
		animPunchLeft.tick();
		animPunchRight.tick();
		
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this); //center the camera on this player after he moves
		
		//Attack
		checkAttacks();

		//Inventory
		inventory.tick();
		
	}
	
	private void checkAttacks(){
		attackTimer += System.currentTimeMillis() - lastAttackTimer; //time elapsed since last attack
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCooldown){ //is the player eligible to attack?
			return; //skip the code below, not ready to attack
		}
		
		Rectangle cb = getCollisionBounds(0,0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().aUp){
			ar.x = cb.x + cb.width / 2 - arSize / 2; //set the collision rectangle width of the player
			ar.y = cb.y - arSize; //set the collision rectangle height of the player
		}else if(handler.getKeyManager().aDown){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
		}else if(handler.getKeyManager().aLeft){
			ar.x = cb.x - arSize; 
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else if(handler.getKeyManager().aRight){
			ar.x = cb.x + cb.width; 
			ar.y = cb.y + cb.height / 2 - arSize / 2; 
		}else{
			return; //not attacking, just return
		}
		
		attackTimer = 0; //set the attack timer to zero because our player will attack
		
		//check for the attack
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this)) //if the entity is our own player, ignore
				continue; //skip the rest of the loop
			if(e.getCollisionBounds(0, 0).intersects(ar)){
				e.hurt(1); //hurt the enemy
				return;
			}
		}
	}
	
	@Override
	public void die(){
		System.out.println("You lose");
	}
	
	private void getInput(){
		
		//Movement Input
		xMove = 0;
		yMove = 0;
		
		if (handler.getKeyManager().up)
			yMove = -speed; //up the y-axis
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
		
		//Attack Input
		leftAttack = false;
		rightAttack = false;
		
		if(handler.getKeyManager().aLeft)
			leftAttack = true;
		if(handler.getKeyManager().aRight)
			rightAttack = true;
		
		
	}
	

	@Override
	public void render(Graphics g) {
		//width and height parameters determine the size of the final size of the player on the screen
		//x and y determine the 
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		//red boundary collision box
/*		g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
				bounds.width, bounds.height);*/
		
		inventory.render(g);
		
		
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0){
			return animLeft.getCurrentFrame();
		}else if(xMove > 0){
			return animRight.getCurrentFrame();
		}else if(yMove < 0){
			return animUp.getCurrentFrame();
		}else{ 
			return animDown.getCurrentFrame();
		}
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

}
