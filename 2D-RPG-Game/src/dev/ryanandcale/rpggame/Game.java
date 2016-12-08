package dev.ryanandcale.rpggame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.ryanandcale.rpggame.display.Display;

public class Game implements Runnable{

	private Display display;

	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;  //buffers prevent flickering by drawing before displaying to the screen
	private Graphics g; //draws images to the canvas
	
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		
	}
	
	//initialize the graphics for our game, get things setup
	private void init(){
		display = new Display(title, width, height);
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
		//Begin Drawing
		
		g.fillRect(0, 0, width, height);
		
		
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
