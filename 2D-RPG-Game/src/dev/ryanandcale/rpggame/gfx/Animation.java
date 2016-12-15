package dev.ryanandcale.rpggame.gfx;

import java.awt.image.BufferedImage;

public class Animation {

	private int speed, index;
	private long lastTime, timer;
	private BufferedImage[] frames;
	
	public Animation(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
		
	}
	
	public void tick(){
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();//reset lastTime to this current tick
		
		if(timer > speed){
			index++;
			timer = 0;
			if(index >= frames.length){ //make sure it does not go out of bounds
				index = 0;
			}
		}
	}
	
	public BufferedImage getCurrentFrame(){
		return frames[index];
	}

}
