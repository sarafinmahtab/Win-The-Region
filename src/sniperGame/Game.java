package sniperGame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import sniperGame.gfx.Assets;
import sniperGame.gfx.World;
import sniperGame.states.About;
import sniperGame.states.GameOverState;
import sniperGame.states.GameState;
import sniperGame.states.GameState2;
import sniperGame.states.Instruction;
import sniperGame.states.MenuState;
import sniperGame.states.State;

/**
 * @author Arafin
 *
 */

public class Game implements Runnable {

	public String title;
	private int width, height;
	private boolean running = false;
	
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;
	
	//Display
	private Display display;
	
	//States
	private State menuState;
	private State gameState;
	private State gameState2;
	private State gameOverState;
	private State instruction;
	private State about;
	
	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//World
	private World world;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}

	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		Assets.init();
		
		menuState = new MenuState(this);		
		gameState = new GameState(this);
		gameState2 = new GameState2(this);
		gameOverState = new GameOverState(this, 0);
		instruction = new Instruction(this);
		about = new About(this);
		
		State.setState(menuState);
	}
	
	private void tick() {
		keyManager.tick();
		
		if(State.getState() != null) {
			State.getState().tick();
		}
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		//Clear Screen
		g.clearRect(0, 0, width, height);		
		
		// States Property
		if(State.getState() != null) {
			State.getState().render(g);
		}
				
		bs.show();
		g.dispose();
	}
	
	@Override
	public void run() {
		init();
		
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		//long ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				//ticks++;
				delta--;
			}
			
			if(timer >= 1000000000) {
				//System.out.println("Times and Frames: " + ticks);
				//ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	//GETTERS
	public Display getDisplay() {
		return display;
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public World getWorld() {
		return world;
	}

	
	public State getMenuState() {
		return menuState;
	}
	
	public State getGameState() {
		return gameState;
	}
	
	public State getGameState2() {
		return gameState2;
	}
	
	public State getGameOverState() {
		return gameOverState;
	}
	
	public State getInstruction() {
		return instruction;
	}
	
	public State getAbout() {
		return about;
	}
	
	//SETTERS
	public void setMenuState(MenuState menuState) {
		this.menuState = menuState;
	}
	
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
	
	public void setGameState2(GameState2 gameState2) {
		this.gameState2 = gameState2;
	}
	
	public void setGameOverState(GameOverState gameOverState) {
		this.gameOverState = gameOverState;
	}
	
	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}
	
	public void setAbout(About about) {
		this.about = about;
	}
	
	
	public void setWorld(World world) {
		this.world = world;
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
