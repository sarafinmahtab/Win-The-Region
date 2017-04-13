package sniperGame.states;

import java.awt.Graphics;

import sniperGame.Game;
import sniperGame.gfx.Assets;
import sniperGame.ui.ClickListener;
import sniperGame.ui.UIImageButton;
import sniperGame.ui.UIManager4;

/**
 * @author Arafin
 *
 */

public class About extends State {
	
	private UIManager4 uiManager4;
	
	public About(Game game) {
		super(game);
		
		uiManager4 = new UIManager4(game);
		game.getMouseManager().setUIManager4(uiManager4);
				
		uiManager4.addObject(new UIImageButton(376, 480, 80, 40, Assets.menu_array, new ClickListener() {
			@Override
			public void onClick() {
				game.getMouseManager().setUIManager4(null);
				game.setMenuState(new MenuState(game));
				State.setState(game.getMenuState());
			}
		}));
	}
	
	@Override
	public void tick() {
		uiManager4.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.aboutSet, 0, 0, null);
		uiManager4.render(g);
	}
}
