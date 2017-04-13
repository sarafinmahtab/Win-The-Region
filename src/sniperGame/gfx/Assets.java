package sniperGame.gfx;

import java.awt.image.BufferedImage;

/**
 * @author Arafin
 *
 */

public class Assets {
	
	public static final int width = 32, height = 32;
	
	public static BufferedImage sniper, dirt, grass, road, scoreBoard,
	explosive, police, policeBack, redCar, redCarBack, greenCar, greenCarBack,
	titleGame, background, instruction, aboutSet, game_over;
	
	public static BufferedImage[] start_button_array, instruction_array,
	about_array, exit_array, restart_array, menu_array, next_array;
	
	private static BufferedImage asset;
	
	public static void init() {
		asset = ImageLoader.loadImage("/textures/NewSpritesheet.png");

		titleGame = ImageLoader.loadImage("/textures/GameScreen_Title.png");
		background = ImageLoader.loadImage("/textures/GameScreen.png");
		instruction = ImageLoader.loadImage("/textures/InstructionSet.png");
		aboutSet = ImageLoader.loadImage("/textures/AboutSet.png");
		game_over = ImageLoader.loadImage("/textures/GameOver.png");
		
		//Start Button
		start_button_array = new BufferedImage[2];
		start_button_array[0] = ImageLoader.loadImage("/textures/StartGame1.png");
		start_button_array[1] = ImageLoader.loadImage("/textures/StartGame2.png");
		
		//Instruction Button
		instruction_array = new BufferedImage[2];
		instruction_array[0] = ImageLoader.loadImage("/textures/Instruction1.png");
		instruction_array[1] = ImageLoader.loadImage("/textures/Instruction2.png");
		
		//About Button
		about_array = new BufferedImage[2];
		about_array[0] = ImageLoader.loadImage("/textures/About1.png");
		about_array[1] = ImageLoader.loadImage("/textures/About2.png");
		
		//Exit Button
		exit_array = new BufferedImage[2];
		exit_array[0] = ImageLoader.loadImage("/textures/Exit1.png");
		exit_array[1] = ImageLoader.loadImage("/textures/Exit2.png");
		
		//Restart Button
		restart_array = new BufferedImage[2];
		restart_array[0] = ImageLoader.loadImage("/textures/Restart1.png");
		restart_array[1] = ImageLoader.loadImage("/textures/Restart2.png");
		
		//Menu Button
		menu_array = new BufferedImage[2];
		menu_array[0] = ImageLoader.loadImage("/textures/Menu1.png");
		menu_array[1] = ImageLoader.loadImage("/textures/Menu2.png");
		
		//Next Button
		next_array = new BufferedImage[2];
		next_array[0] = ImageLoader.loadImage("/textures/Next1.png");
		next_array[1] = ImageLoader.loadImage("/textures/Next2.png");
		
		//GamePlay Objects
		SpriteSheet sheet = new SpriteSheet(asset);
		
		dirt = sheet.crop(0, 8*height, 2*width, 2*height);
		road = sheet.crop(4*width, 0, 4*height, 4*height);
		grass = sheet.crop(4*width, 12*height, 2*height, 2*width);
		sniper = sheet.crop(0, 0, 4*width-1, 4*height);
		police = sheet.crop(10*width, 0, 4*width, 2*height);
		policeBack = sheet.crop(12*width, 10*height, 4*width, 2*height);
		greenCar = sheet.crop(10*width, 2*height, 4*width, 2*height);
		greenCarBack = sheet.crop(12*width, 8*height, 4*width, 2*height);
		redCar = sheet.crop(10*width, 4*height, 4*width, 2*height);
		redCarBack = sheet.crop(12*width, 6*height, 4*width, 2*height);
		scoreBoard = sheet.crop(8*width, 8*height, 4*width, 2*height-20);
	}
}
