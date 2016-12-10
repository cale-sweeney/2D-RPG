package dev.ryanandcale.rpggame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.ryanandcale.rpggame.display.Display;
import dev.ryanandcale.rpggame.gfx.Assets;
import dev.ryanandcale.rpggame.gfx.ImageLoader;
import dev.ryanandcale.rpggame.gfx.SpriteSheet;
import dev.ryanandcale.rpggame.input.KeyManager;
import dev.ryanandcale.rpggame.states.GameState;
import dev.ryanandcale.rpggame.states.MenuState;
import dev.ryanandcale.rpggame.states.State;

public class Game implements Runnable{

	private Display display;

	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;  //buffers prevent flickering by drawing before displaying to the screen
	private Graphics g; //draws images to the canvas
	
	//States
	private State gameState;
	private State menuState;
	
	//Input
	private KeyManager keyManager;
	
	//private BufferedImage test;
	//private SpriteSheet sheet;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		
	}
	
	//initialize the graphics for our game, get things setup
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		//test = ImageLoader.loadImage("/textures/SpriteSheet1.jpg");
		//sheet = new SpriteSheet(test);
		Assets.init();
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(gameState);
	}
	

	
	//update all the variables for our game
	//
	private void tick(){
		keyManager.tick();
		
		if(State.getState() != null)
			State.getState().tick();
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
		
		//Begin Drawing (the order you place your code matters)
		
		if(State.getState() != null)
			State.getState().render(g);
		
		//g.drawImage(Assets.grass, 0, 10, null);
		
		
		//g.drawImage(sheet.crop(0, 0, 87, 97), 5, 5, null);
		//g.drawImage(sheet.crop(99, 0, 87, 97), 100, 100, null);
		
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
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			//prints the frames per second on to the screen
			if (timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
			
		}
		
		stop();
	}
	
	//So other classes can access the keyManager
	public KeyManager getKeyManager(){
		return keyManager;
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
