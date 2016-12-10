package dev.ryanandcale.rpggame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 100, height = 100;
	
	public static BufferedImage player, bush, agave, grass, dirt;
	
	public static void init(){
		SpriteSheet masterSheet = new SpriteSheet(ImageLoader.loadImage("/textures/MasterSheet.png"));
	
		player = masterSheet.crop(0, 0, height, width);
		dirt = masterSheet.crop(0, 100, height, width);
		bush = masterSheet.crop(100, 0, height, width);
		agave = masterSheet.crop(200, 0, height, width);
		grass = masterSheet.crop(100, 100, height, width);
	}
	
}
