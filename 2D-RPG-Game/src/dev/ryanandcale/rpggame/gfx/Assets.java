package dev.ryanandcale.rpggame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 100, height = 100; //classic default tile height and width
	
	public static BufferedImage bush, agave, grass, dirt, rock, tree, wood, stone;
	public static BufferedImage title;
	
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] player_punch_left, player_punch_right, player_punch_down, player_punch_up;

	public static BufferedImage[] werewolf_down, werewolf_up, werewolf_left, werewolf_right;
	public static BufferedImage[] werewolf_claw_down, werewolf_claw_up, werewolf_claw_left, werewolf_claw_right;
	
	public static BufferedImage[] btn_start;
	
	public static void init(){
		SpriteSheet masterSheet = new SpriteSheet(ImageLoader.loadImage("/textures/MasterSheetv8.png"));
		SpriteSheet startButtonSheet = new SpriteSheet(ImageLoader.loadImage("/textures/MenuStartButton.png"));
		SpriteSheet werewolfSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Werewolf2.png"));
	
		//Non-Creature Entity Assets
		
		wood = masterSheet.crop(300, 200, width, height);
		stone = masterSheet.crop(300, 300, width, height);
		
		dirt = masterSheet.crop(0, 100, height, width);
		bush = masterSheet.crop(100, 0, height, width);
		agave = masterSheet.crop(200, 0, height, width);
		grass = masterSheet.crop(100, 100, height, width);
		rock = masterSheet.crop(200, 100, height, width);
		tree = masterSheet.crop(300, 0, height * 2, width);
		
		//Player Image Assets
		
		player_down = new BufferedImage[3];
		player_up = new BufferedImage[3];
		player_left = new BufferedImage[3];
		player_right = new BufferedImage[3];

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
		
		player_punch_right = new BufferedImage[3];
		player_punch_left = new BufferedImage[3];
		player_punch_down = new BufferedImage[3];
		player_punch_up = new BufferedImage[3];
		
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
		

		//Werewolf Image Assets
		werewolf_down = new BufferedImage[4];
		werewolf_up = new BufferedImage[4];
		werewolf_left = new BufferedImage[4];
		werewolf_right = new BufferedImage[4];
		
		werewolf_down[0] = werewolfSheet.crop(0, 0, height, width);
		werewolf_down[1] = werewolfSheet.crop(100, 0, height, width);
		werewolf_down[2] = werewolfSheet.crop(200, 0, height, width);
		werewolf_down[3] = werewolfSheet.crop(300, 0, height, width);
		
		werewolf_left[0] = werewolfSheet.crop(0, 100, height, width);
		werewolf_left[1] = werewolfSheet.crop(100, 100, height, width);
		werewolf_left[2] = werewolfSheet.crop(200, 100, height, width);
		werewolf_left[3] = werewolfSheet.crop(300, 100, height, width);
		
		werewolf_right[0] = werewolfSheet.crop(0, 200, height, width);
		werewolf_right[1] = werewolfSheet.crop(100, 200, height, width);
		werewolf_right[2] = werewolfSheet.crop(200, 200, height, width);
		werewolf_right[3] = werewolfSheet.crop(300, 200, height, width);
		
		werewolf_up[0] = werewolfSheet.crop(0, 300, height, width);
		werewolf_up[1] = werewolfSheet.crop(100, 300, height, width);
		werewolf_up[2] = werewolfSheet.crop(200, 300, height, width);
		werewolf_up[3] = werewolfSheet.crop(300, 300, height, width);
		
		werewolf_claw_right = new BufferedImage[4];
		werewolf_claw_left = new BufferedImage[4];
		werewolf_claw_down = new BufferedImage[4];
		werewolf_claw_up = new BufferedImage[4];
		
		werewolf_claw_down[0] = werewolfSheet.crop(400, 0, height, width);
		werewolf_claw_down[1] = werewolfSheet.crop(500, 0, height, width);
		werewolf_claw_down[2] = werewolfSheet.crop(600, 0, height, width);
		werewolf_claw_down[3] = werewolfSheet.crop(700, 0, height, width);
  
    	werewolf_claw_left[0] = werewolfSheet.crop(400, 100, height, width);
		werewolf_claw_left[1] = werewolfSheet.crop(500, 100, height, width);
		werewolf_claw_left[2] = werewolfSheet.crop(600, 100, height, width);
		werewolf_claw_left[3] = werewolfSheet.crop(700, 100, height, width);	
  
		werewolf_claw_right[3] = werewolfSheet.crop(700, 200, height, width);
		werewolf_claw_right[2] = werewolfSheet.crop(600, 200, height, width);
		werewolf_claw_right[1] = werewolfSheet.crop(500, 200, height, width);
		werewolf_claw_right[0] = werewolfSheet.crop(400, 200, height, width);
		
		werewolf_claw_up[0] = werewolfSheet.crop(400, 300, height, width);
		werewolf_claw_up[1] = werewolfSheet.crop(500, 300, height, width);
		werewolf_claw_up[2] = werewolfSheet.crop(600, 300, height, width);
		werewolf_claw_up[3] = werewolfSheet.crop(700, 300, height, width);
		
		//Start Menu Images
		
		btn_start = new BufferedImage[2];
				
		btn_start[0] = startButtonSheet.crop(0, 0, 150, 300);
		btn_start[1] = startButtonSheet.crop(0, 150, 150, 300);
		title = startButtonSheet.crop(0, 300, 200, 600);
		
		
	}
	
}
