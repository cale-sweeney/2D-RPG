package dev.ryanandcale.rpggame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.ryanandcale.rpggame.display.Display;
import dev.ryanandcale.rpggame.gfx.ImageLoader;
import dev.ryanandcale.rpggame.gfx.SpriteSheet;

public class Game implements Runnable{

	private Display display;

	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;  //buffers prevent flickering by drawing before displaying to the screen
	private Graphics g; //draws images to the canvas
	
	private BufferedImage test;
	private SpriteSheet sheet;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		
	}
	
	//initialize the graphics for our game, get things setup
	private void init(){
		display = new Display(title, width, height);
		test = ImageLoader.loadImage("/textures/SpriteSheet1.jpg");
		sheet = new SpriteSheet(test);
	}
	
	//update all the variables for our game
	private void tick(){
		
	}
	
	//update all the rendering for our game
	private void render(){
		bs = display.getCanvas().getBufferStrategy(); 
		if(bs == null){
			display.getCanvas().createBufferStrategy(3); //use 3 buffers
			return;
		}
		g = bs.getDrawGraphics();
		//clear screen
		g.clearRect(0, 0, width, height);
		
		//Begin Drawing
		//The order you place your code matters.
		
		g.drawImage(sheet.crop(0, 0, 87, 97), 5, 5, null);
		g.drawImage(sheet.crop(99, 0, 87, 97), 100, 100, null);
		
		//Draw Rectangles
		//g.drawRect(10, 50, 50, 70);
/*		g.setColor(Color.red);
		g.fillRect(10, 50, 50, 70);
		g.setColor(Color.green);
		g.fillRect(0, 0, 10, 10);*/
		
		
		//End Drawing
		bs.show();
		g.dispose();
		
		
	}
	
	//majority of game code goes here
	public void run(){
		
		init();
		
		while(running){
			tick();
			render();
		}
		
		stop();
	}
	
	public synchronized void start(){
		if(running) //check to see if its already running
			return; //if it is running, don't re-run
		running = true;
		thread = new Thread(this);
		thread.start(); //This calls the run method
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join(); //closes the thread
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
