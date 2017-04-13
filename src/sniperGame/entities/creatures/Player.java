package sniperGame.entities.creatures;

import java.awt.Graphics;

import sniperGame.Game;
import sniperGame.gfx.Assets;

/**
 * @author Arafin
 *
 */

public class Player extends Creature {

	private Game game;
	
	public Player(Game game, float x, float y) {
		super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH*2, Creature.DEFAULT_CREATURE_HEIGHT*2);
		this.game = game;
	}
	
	@Override
	public void tick() {
		getInput();
		playerMove();
		action();
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up)
			yMove = -speed;
		if(game.getKeyManager().down)
			yMove = speed;
		if(game.getKeyManager().left)
			xMove = -speed;
		if(game.getKeyManager().right)
			xMove = speed;
	}
	
	public boolean action() {
		if(game.getKeyManager().shot)
			return true;
		return false;
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.sniper, (int) x, (int) y, (int)width, (int)height, null);
	}
}
