package dev.ryanandcale.rpggame.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	public static BufferedImage loadImage(String path){
		
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1); //If we can't load our image, we don't want to run our game.
		}
		return null; //java makes us return this to wipe out all of the errors
	}

}
