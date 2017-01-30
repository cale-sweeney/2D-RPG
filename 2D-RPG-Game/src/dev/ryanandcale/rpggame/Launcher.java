package dev.ryanandcale.rpggame;

public class Launcher {

	public static void main(String[] args){
	
		Game game = new Game("2D RPG!", 900, 900); //Title, width, height
		game.start();
		
	}
	
}
