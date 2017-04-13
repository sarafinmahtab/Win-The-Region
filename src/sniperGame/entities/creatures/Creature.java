package sniperGame.entities.creatures;

import sniperGame.Game;

/**
 * @author Arafin
 *
 */

public abstract class Creature extends Entity {
		
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 5.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;
	
	private Game game;

	public Creature(Game game, float x, float y, int width, int height) {
		super(x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		this.game = game;
	}
	
	public void playerMove(){
		if((x+xMove) <= -40 || (x+xMove) > game.getWidth()-80) {
			xMove = 0;
		}
		
		if((y+yMove) <= -40 || (y+yMove) > game.getHeight()-100) {
			yMove = 0;
		}
		x += xMove;
		y += yMove;
	}
	
	public void carMove() {
		x += xMove;
		y += yMove;
	}
	
	//GETTERS SETTERS

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}
}
