package dev.ryanandcale.rpggame.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import dev.ryanandcale.rpggame.Handler;
import dev.ryanandcale.rpggame.entities.Entity;
import dev.ryanandcale.rpggame.gfx.Animation;
import dev.ryanandcale.rpggame.gfx.Assets;
import dev.ryanandcale.rpggame.inventory.Inventory;

public class Werewolf extends Enemy {

	//Movement Animations
	private Animation animWerewolfDown, animWerewolfUp, animWerewolfLeft, animWerewolfRight;
	
	//Attack Animations
	private Animation animWerewolfClawLeft, animWerewolfClawRight, animWerewolfClawDown, animWerewolfClawUp;
	
	//Attack timer
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
	
	//to slow down movement
	private int tickCounter;
	
	public static int WEREWOLF_AWARENESS_RANGE = 500;

	public Werewolf(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, WEREWOLF_AWARENESS_RANGE);
		
		//boundary collision
		physicalBounds.x = 16;
		physicalBounds.y = 32;
		physicalBounds.width = 32;
		physicalBounds.height = 32;
		
		//Movement Animation
		animWerewolfDown = new Animation(400, Assets.werewolf_down);
		animWerewolfUp = new Animation(400, Assets.werewolf_up);
		animWerewolfLeft = new Animation(400, Assets.werewolf_left);
		animWerewolfRight = new Animation(400, Assets.werewolf_right);
		
		this.tickCounter = 0;
		
		//Attack Animation
		animWerewolfClawLeft = new Animation(150, Assets.werewolf_claw_left);
		animWerewolfClawRight = new Animation(150, Assets.werewolf_claw_right);
		animWerewolfClawDown = new Animation(150, Assets.werewolf_claw_down);
		animWerewolfClawUp = new Animation(150, Assets.werewolf_claw_up);

	}

	@Override
	public void tick() {
		
		tickCounter++;
		
		//Movement Animations
		animWerewolfDown.tick();
		animWerewolfUp.tick();
		animWerewolfLeft.tick();
		animWerewolfRight.tick();
		
		//Attack Animations
		animWerewolfClawLeft.tick();
		animWerewolfClawRight.tick();
		animWerewolfClawDown.tick();
		animWerewolfClawUp.tick();
		
		//Movement
		if(tickCounter == 50){
			enemyLooksForPlayer();
			getEnemyWanderDirection();
			move();
			tickCounter = 0;
		}
		//Attack
		checkAttacks();
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
	
	private void getEnemyWanderDirection(){
		
		
		
		//Movement Input
		xMove = 0;
		yMove = 0;
		
		Random randomNumber = new Random();
		int random = randomNumber.nextInt(4);

		if (random == 0){
			yMove = -speed; //up the y-axis
		}
		if (random == 1){
			yMove = speed;
		}
		if (random == 2){
			xMove = -speed;
		}
		if (random == 3) {
			xMove = speed;
		}
		
	
		//Attack Input
		attack = false;
		
/*		if(handler.getKeyManager().aLeft || handler.getKeyManager().aRight || handler.getKeyManager().aDown || handler.getKeyManager().aUp)
			attack = true;*/
	
		
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
		
/*		if(handler.getKeyManager().aUp){
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
		}*/
		
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
	
	private BufferedImage getCurrentAnimationFrame(){
		
		//attack animations take priority over movement animations
/*		if(attack){
			if(handler.getKeyManager().aLeft){
				return animPunchLeft.getCurrentFrame();
			}else if(handler.getKeyManager().aRight){
				return animPunchRight.getCurrentFrame();
			}else if(handler.getKeyManager().aDown){
				return animPunchDown.getCurrentFrame();
			}else if(handler.getKeyManager().aUp){
				return animPunchUp.getCurrentFrame();
				
			}	
		}*/
		
		//movement animations
		if(xMove < 0){
			return animWerewolfLeft.getCurrentFrame();
		}else if(xMove > 0){
			return animWerewolfRight.getCurrentFrame();
		}else if(yMove < 0){
			return animWerewolfUp.getCurrentFrame();
		}else{ 
			return animWerewolfDown.getCurrentFrame();
		}
	}

}
