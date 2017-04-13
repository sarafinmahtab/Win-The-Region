package sniperGame.entities.creatures;

import java.awt.Graphics;

import sniperGame.Game;
import sniperGame.gfx.Assets;

public class Explosion extends Creature {

	public Explosion(Game game, float x, float y) {
		super(game, x, y, (Creature.DEFAULT_CREATURE_WIDTH-50), Creature.DEFAULT_CREATURE_HEIGHT-50);
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.explosive, width, height, null);
	}
}
