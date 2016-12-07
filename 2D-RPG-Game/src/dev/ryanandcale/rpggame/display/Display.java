package dev.ryanandcale.rpggame.display;

import javax.swing.JFrame;

public class Display {
	
	private JFrame frame;
	
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}


}
