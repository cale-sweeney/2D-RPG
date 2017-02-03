package dev.ryanandcale.rpggame.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage sheet;
	
	
	public SpriteSheet(BufferedImage sheet){
		this.sheet = sheet;
	}
	
	//crop out characters on the sprite sheet
	public BufferedImage crop(int x, int y, int height, int width){
		
		return sheet.getSubimage(x, y, width, height);
	}
	
}
