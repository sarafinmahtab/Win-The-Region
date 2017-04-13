package sniperGame.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import sniperGame.Game;
import sniperGame.entities.creatures.GreenCar;
import sniperGame.entities.creatures.GreenCarBack;
import sniperGame.entities.creatures.Player;
import sniperGame.entities.creatures.PoliceCar;
import sniperGame.entities.creatures.PoliceCarBack;
import sniperGame.entities.creatures.RedCar;
import sniperGame.entities.creatures.RedCarBack;
import sniperGame.gfx.Assets;
import sniperGame.gfx.World;

public class GameState2 extends State implements Runnable {
	
	private Player player;
	private World world;
	
	private PoliceCar policeCar;
	private PoliceCarBack policeCarBack;
	
	private GreenCar greenCar;
	private GreenCarBack greenCarBack;
	
	private RedCar redCar;
	private RedCarBack redCarBack;
		
	private Rectangle pointer, policeRec, policeBackRec, greenRec, greenBackRec, redRec, redBackRec;
	
	private Random ran = new Random();
	private Thread t;
	private int[] dx = {-50, 1200, -100, 900, -360, 1000},
				  dy = {230, 390, 295, 200, 425, 265};
	public static int target2, score2;
	private double timer;
	public static boolean won2 = false;
	
	public GameState2(Game game) {
		super(game);
		
		world = new World("res/worlds/world3.txt");
		game.setWorld(world);
		
		target2 = 8;
		score2 = 0;
//		timer = 41*60;
		timer = 300;
		
		t = new Thread(this);
		t.start();
		
		player = new Player(game, 200, 200);
	}
	
	@Override
	public void tick() {
		world.tick();

		player.tick();

		policeCar.tick();
		policeCarBack.tick();
		
		greenCar.tick();
		greenCarBack.tick();
		
		redCar.tick();
		redCarBack.tick();
		
		isCollide();
		
		if(timer <= 0 && score2 >= target2) {
			timer = 0;
			won2 = true;
			game.setGameOverState(new GameOverState(game, 2));
			State.setState(game.getGameOverState());
		} else if(timer <= 0 && score2 < target2) {
			timer = 0;
			won2 = false;
			game.setGameOverState(new GameOverState(game, 2));
			State.setState(game.getGameOverState());
		}
		
		timer = timer-0.5;
	}
	
	public void isCollide() {
		pointer = new Rectangle((int)(player.getX()+62), (int)(player.getY()+62), 4, 4);
		
		policeRec = new Rectangle((int)(policeCar.getX()), (int)(policeCar.getY()),
				(int)policeCar.getWidth(), (int)policeCar.getHeight());
		policeBackRec = new Rectangle((int)(policeCarBack.getX()), (int)(policeCarBack.getY()),
				(int)policeCarBack.getWidth(), (int)policeCarBack.getHeight());
		
		greenRec = new Rectangle((int)(greenCar.getX()), (int)(greenCar.getY()), 
				(int)greenCar.getWidth(), (int)greenCar.getHeight());
		greenBackRec = new Rectangle((int)(greenCarBack.getX()), (int)(greenCarBack.getY()), 
				(int)greenCarBack.getWidth(), (int)greenCarBack.getHeight());
		
		redRec = new Rectangle((int)(redCar.getX()), (int)(redCar.getY()), 
				(int)redCar.getWidth(), (int)redCar.getHeight());
		redBackRec =  new Rectangle((int)(redCarBack.getX()), (int)(redCarBack.getY()), 
				(int)redCarBack.getWidth(), (int)redCarBack.getHeight());
		
		if(pointer.intersects(policeRec) && player.action()) {
			policeCar = new PoliceCar(game,-2000, -2000);
			score2 += 1;
		}
		
		if(pointer.intersects(policeBackRec) && player.action()) {
			policeCarBack = new PoliceCarBack(game,-2000, -2000);
			score2 += 1;
		}
		
		if(pointer.intersects(greenRec) && player.action()) {
			greenCar = new GreenCar(game, -2000, -2000);
			score2 += 2;
		}
		
		if(pointer.intersects(greenBackRec) && player.action()) {
			greenCarBack = new GreenCarBack(game,-2000, -2000);
			score2 += 2;
		}
		
		if(pointer.intersects(redRec) && player.action()) {
			redCar = new RedCar(game, -2000, -2000);
			score2 += 5;
		}
		
		if(pointer.intersects(redBackRec) && player.action()) {
			redCarBack = new RedCarBack(game, -2000, -2000);
			score2 += 5;
		}
		
		//Car to Car Intersection
		if(policeRec.intersects(greenRec)) {
			policeCar.setSpeed(0.0f);
		}
		
		if(policeRec.intersects(redRec)) {
			policeCar.setSpeed(0.0f);
		}
		
		if(greenRec.intersects(redRec)) {
			greenCar.setSpeed(0.0f);
		}
		
		if(policeBackRec.intersects(greenBackRec)) {
			policeCarBack.setSpeed(0.0f);
		}
		
		if(policeBackRec.intersects(redBackRec)) {
			policeCarBack.setSpeed(0.0f);
		}
		
		if(greenBackRec.intersects(redBackRec)) {
			greenCarBack.setSpeed(0.0f);
		}
	}
	
	@Override
	public void render(Graphics g) {
		world.render(g);
		
		policeCar.render(g);
		policeCarBack.render(g);
		
		greenCar.render(g);
		greenCarBack.render(g);
		
		redCar.render(g);
		redCarBack.render(g);
		
		player.render(g);
		
		g.drawImage(Assets.scoreBoard, 20, 0, null);
		g.drawImage(Assets.scoreBoard, 353, 0, null);
		g.drawImage(Assets.scoreBoard, 680, 0, null);

		g.setFont(new Font("Chaparral Pro Light", Font.BOLD, 18));
		g.setColor(Color.WHITE);
		g.drawString("Score: " + score2, 45, 24);
		g.drawString("Target: " + target2, 378, 24);
		g.drawString("Timer: "+ (int)(timer/60), 705, 24);
	}
	
	int index;
	@Override
	public void run() {
		
		try {
			
			for(int i = 0; i <= 15; i++) {

				index = ran.nextInt(5);
				policeCar = new PoliceCar(game, dx[index], dy[index]);
				
				index = ran.nextInt(5);
				policeCarBack = new PoliceCarBack(game, dx[index], dy[index]);
				
				index = ran.nextInt(5);
				greenCar = new GreenCar(game, dx[index], dy[index]);
				
				index = ran.nextInt(5);
				greenCarBack = new GreenCarBack(game, dx[index], dy[index]);
				
				index = ran.nextInt(5);
				redCar = new RedCar(game, dx[index], dy[index]);
				
				index = ran.nextInt(5);
				redCarBack = new RedCarBack(game, dx[index], dy[index]);
				
				Thread.sleep(6000);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
