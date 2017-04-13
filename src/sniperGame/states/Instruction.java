package sniperGame.states;

import java.awt.Graphics;

import sniperGame.Game;
import sniperGame.gfx.Assets;
import sniperGame.ui.ClickListener;
import sniperGame.ui.UIImageButton;
import sniperGame.ui.UIManager3;

/**
 * @author Arafin
 *
 */

public class Instruction extends State {
	
	private UIManager3 uiManager3;

	public Instruction(Game game) {
		super(game);
		
		uiManager3 = new UIManager3(game);
		game.getMouseManager().setUIManager3(uiManager3);
				
		uiManager3.addObject(new UIImageButton(90, 500, 80, 40, Assets.menu_array, new ClickListener() {
			@Override
			public void onClick() {
				game.getMouseManager().setUIManager3(null);
				game.setMenuState(new MenuState(game));
				State.setState(game.getMenuState());
			}
		}));
	}
	
	@Override
	public void tick() {
		uiManager3.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.instruction, 0, 0, null);
		uiManager3.render(g);
	}
	
	public UIManager3 getUIManager3() {
		return uiManager3;
	}
}
