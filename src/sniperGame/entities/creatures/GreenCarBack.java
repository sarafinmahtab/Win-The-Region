package sniperGame.entities.creatures;

import java.awt.Graphics;

import sniperGame.Game;
import sniperGame.gfx.Assets;

/**
 * @author Arafin
 *
 */

public class GreenCarBack extends Creature {
	
	private boolean up = false, updown = false;

	public GreenCarBack(Game game, float x, float y) {
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
		greenCarInput();
		carMove();
	}
	
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	private void greenCarInput() {
		xMove = -speed;
		
		if(speed == 0) {
			speed = 4.8f;
		}
		
		if(up == true) {
			if(x >= 240 && x <= 345) {
				yMove = 3;
			} else {
				yMove = 0;
			}
		}
		
		if(updown == true) {
			if(x >= 68 && x <= 250) {
				yMove = 3.5f;
			} else if(x >= 575 && x <= 760) {
				yMove = -3.5f;
			} else {
				yMove = 0;
			}
		}
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.greenCarBack, (int)x, (int)y, width, height, null);
	}
}
