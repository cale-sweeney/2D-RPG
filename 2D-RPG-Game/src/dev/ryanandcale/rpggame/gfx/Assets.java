package dev.ryanandcale.rpggame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 100, height = 100; //classic default tile height and width
	
	public static BufferedImage bush, agave, grass, dirt, rock, tree, wood, stone;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] player_punch_left, player_punch_right, player_punch_down, player_punch_up;
	
	public static BufferedImage[] btn_start;
	
	public static void init(){
		SpriteSheet masterSheet = new SpriteSheet(ImageLoader.loadImage("/textures/MasterSheetv8.png"));
		SpriteSheet startButtonSheet = new SpriteSheet(ImageLoader.loadImage("/textures/MenuStartButton.png"));
	
		wood = masterSheet.crop(300, 200, width, height);
		stone = masterSheet.crop(300, 300, width, height);
		
		
		player_down = new BufferedImage[3];
		player_up = new BufferedImage[3];
		player_left = new BufferedImage[3];
		player_right = new BufferedImage[3];
		
		player_punch_right = new BufferedImage[3];
		player_punch_left = new BufferedImage[3];
		player_punch_down = new BufferedImage[3];
		player_punch_up = new BufferedImage[3];
		
		player_down[0] = masterSheet.crop(0, 200, height, width);
		player_down[1] = masterSheet.crop(100, 200, height, width);
		player_down[2] = masterSheet.crop(200, 200, height, width);
		
		player_up[0] = masterSheet.crop(0, 300, height, width);
		player_up[1] = masterSheet.crop(100, 300, height, width);
		player_up[2] = masterSheet.crop(200, 300, height, width);
		
		player_left[0] = masterSheet.crop(0, 400, height, width);
		player_left[1] = masterSheet.crop(100, 400, height, width);
		player_left[2] = masterSheet.crop(200, 400, height, width);
		
		player_right[0] = masterSheet.crop(0, 500, height, width);
		player_right[1] = masterSheet.crop(100, 500, height, width);
		player_right[2] = masterSheet.crop(200, 500, height, width);
		
		player_punch_right[0] = masterSheet.crop(0, 600, height, width);
		player_punch_right[1] = masterSheet.crop(100, 600, height, width);
		player_punch_right[2] = masterSheet.crop(200, 600, height, width);
		
		player_punch_left[2] = masterSheet.crop(0, 700, height, width);
		player_punch_left[1] = masterSheet.crop(100, 700, height, width);
		player_punch_left[0] = masterSheet.crop(200, 700, height, width);
		
		player_punch_down[0] = masterSheet.crop(300, 600, height, width);
		player_punch_down[1] = masterSheet.crop(400, 600, height, width);
		player_punch_down[2] = masterSheet.crop(500, 600, height, width);
		
		player_punch_up[0] = masterSheet.crop(300, 700, height, width);
		player_punch_up[1] = masterSheet.crop(400, 700, height, width);
		player_punch_up[2] = masterSheet.crop(500, 700, height, width);
		
		//player = masterSheet.crop(0, 0, height, width);
		dirt = masterSheet.crop(0, 100, height, width);
		bush = masterSheet.crop(100, 0, height, width);
		agave = masterSheet.crop(200, 0, height, width);
		grass = masterSheet.crop(100, 100, height, width);
		rock = masterSheet.crop(200, 100, height, width);
		tree = masterSheet.crop(300, 0, height * 2, width);
		
		btn_start = new BufferedImage[2];
		
		btn_start[0] = startButtonSheet.crop(0, 0, 150, 300);
		btn_start[1] = startButtonSheet.crop(0, 150, 150, 300);
	}
	
}
