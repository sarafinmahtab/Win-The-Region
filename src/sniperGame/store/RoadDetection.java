package sniperGame.store;

/**
 * @author Arafin
 *
 */

public class RoadDetection {
	/*
	package sniperGame.states;

	import java.awt.Graphics;
	import java.awt.Rectangle;

	import sniperGame.Game;
	import sniperGame.entities.creatures.GreenCar;
	import sniperGame.entities.creatures.GreenCarBack;
	import sniperGame.entities.creatures.Player;
	import sniperGame.entities.creatures.PoliceCar;
	import sniperGame.entities.creatures.PoliceCarBack;
	import sniperGame.entities.creatures.RedCar;
	import sniperGame.entities.creatures.RedCarBack;
	import sniperGame.gfx.World;

	public class GameState extends State implements Runnable {
		
		private Player player;
		private World world;
		
		private PoliceCar policeCar;
		private PoliceCarBack policeCarBack;
		
		private GreenCar greenCar;
		private GreenCarBack greenCarBack;
		
		private RedCar redCar;
		private RedCarBack redCarBack;
		
		private Thread t;
		
		private Rectangle pointer, policeRec, policeBackRec, greenRec, greenBackRec, redRec, redBackRec;
		
		public GameState(Game game){
			super(game);
			world = new World("res/worlds/world2.txt");
			game.setWorld(world);
			
			t = new Thread(this);
			t.start();
			player = new Player(game, 200, 200);
		}
		
		@Override
		public void tick() {
			world.tick();
			
			policeCar.tick();
			policeCarBack.tick();
			
			greenCar.tick();
			greenCarBack.tick();
			
			redCar.tick();
			redCarBack.tick();
			
			player.tick();
			
			isCollide();
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
//			g.fillRect(policeRec.x, policeRec.y, policeRec.width, policeRec.height);
//			g.fillRect(greenBackrec.x, greenBackrec.y, greenBackrec.width, greenBackrec.height);

//			g.fillRect(pointer.x, pointer.y, pointer.width, pointer.height);
		}
		
		
		//Police Car in Thread
		@Override
		public void run() {
			try {
				for(int i = 0; i < 10; i++) {
					policeCar = new PoliceCar(game, 0, 445);
					policeCarBack = new PoliceCarBack(game, 832, 260);
					
					greenCar = new GreenCar(game, 0, 128);
					greenCarBack = new GreenCarBack(game, 900, 482);
					
					redCar = new RedCar(game, -70, 360);
					redCarBack = new RedCarBack(game, 0, 0);
					
					Thread.sleep(6000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
			}
			
			if(pointer.intersects(policeBackRec) && player.action()) {
				policeCarBack = new PoliceCarBack(game,-2000, -2000);
			}
			
			if(pointer.intersects(greenRec) && player.action()) {
				greenCar = new GreenCar(game, -2000, -2000);
			}
			
			if(pointer.intersects(greenBackRec) && player.action()) {
				greenCarBack = new GreenCarBack(game,-2000, -2000);
			}
			
			if(pointer.intersects(redRec) && player.action()) {
				redCar = new RedCar(game, -2000, -2000);
			}
			
			if(pointer.intersects(redBackRec) && player.action()) {
				redCarBack = new RedCarBack(game, -2000, -2000);
			}
		}
	}
*/
}
