
package sniperGame.entities.creatures;

import java.awt.Graphics;

import sniperGame.Game;
import sniperGame.gfx.Assets;

/**
 * @author Arafin
 *
 */

public class PoliceCar extends Creature {
	
	private boolean up = false, updown = false;

	public PoliceCar(Game game, float x, float y) {
		super(game, x, y, (Creature.DEFAULT_CREATURE_WIDTH-40)*2, Creature.DEFAULT_CREATURE_HEIGHT-40);
		speed = 4.8f;
		
		if(x == -360 && y == 360) {
			up = true;
		} else if(x == 1200 && y == 260) {
			up = true;
		}
		
		if(x == 900 && y == 200) {
			updown = true;
		} else if(x == -50 && y == 230) {
			updown = true;
		}
	}
	
	@Override
	public void tick() {
		carInput();
		carMove();
	}
	
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	private void carInput() {
		xMove = speed;
		
		if(speed == 0) {
			speed = 4.8f;
		}
		
		if(up == true) {
			if(x >= 200 && x <= 305) {
				yMove = -3;
			} else {
				yMove = 0;
			}
		}
		
		if(updown == true) {
			if(x >= 63 && x <= 230) {
				yMove = -3.8f;
			} else if(x >= 578 && x <= 750) {
				yMove = 3.8f;
			} else {
				yMove = 0;
			}
		}
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.police, (int)x, (int)y, width, height, null);
	}
	
	/*
	public void carInput() {
		
		int posX = Math.round(x/Tile.TILEWIDTH);
		int posY = Math.round(y/Tile.TILEHEIGHT);
				
		if(inRange(posX+1, posY) && game.getWorld().carInRoad(posX+1, posY)) {
			xMove = speed;
			posX = posX+1;
		} else if(inRange(posX-1, posY) && game.getWorld().carInRoad(posX-1, posY)) {
			xMove = -speed;
			posX = posX-1;
		}
		
		if(inRange(posX, posY-1) && game.getWorld().carInRoad(posX, posY-1)) {
			yMove = -speed;
			posY = posY-1;
		} else if(inRange(posX, posY+1) && game.getWorld().carInRoad(posX, posY+1)) {
			yMove = speed;
			posY = posY+1;
		}
		
		//System.out.println(posX + " " + posY);
	}
	
	private boolean inRange(int posX, int posY) {
		
		if(posX >= 0 && posX < game.getWorld().getWidth() && posY >= 0 && posY < game.getWorld().getHeight()) {
			return true;
		}
		return false;
	}
*/
}
