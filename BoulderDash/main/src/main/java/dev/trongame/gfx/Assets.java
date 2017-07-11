package dev.trongame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

private static final int width = 16, height = 16;
	
	public static BufferedImage player1, player2;
	public static BufferedImage black, wall;
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/16.png"));
		
		player1 = sheet.crop(0, 0, width, height);
		player2 = sheet.crop(width, 0, width, height); 
		
		
		SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/textures/mur16.png"));
		
		black = sheet1.crop(width, 0, width, height);
		wall = sheet1.crop(0, 0, width, height);
	}
}
