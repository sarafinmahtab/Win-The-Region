package sniperGame.states;

import java.awt.Graphics;

import sniperGame.Game;
import sniperGame.gfx.Assets;
import sniperGame.ui.ClickListener;
import sniperGame.ui.UIImageButton;
import sniperGame.ui.UIManager;

/**
 * @author Arafin
 *
 */

public class MenuState extends State {

	private UIManager uiManager;

	public MenuState(Game game) {
		super(game);
		
		uiManager = new UIManager(game);
		game.getMouseManager().setUIManager(uiManager);
				
		uiManager.addObject(new UIImageButton(335, 200, 160, 40, Assets.start_button_array, new ClickListener() {
			@Override
			public void onClick() {
				game.getMouseManager().setUIManager(null);
				game.setGameState(new GameState(game));
				State.setState(game.getGameState());
			}
		}));
		
		uiManager.addObject(new UIImageButton(319, 260, 192, 40, Assets.instruction_array, new ClickListener() {
			@Override
			public void onClick() {
				game.getMouseManager().setUIManager(null);
				game.setInstruction(new Instruction(game));
				State.setState(game.getInstruction());
			}
		}));
		
		uiManager.addObject(new UIImageButton(365, 320, 96, 40, Assets.about_array, new ClickListener() {
			@Override
			public void onClick() {
				game.getMouseManager().setUIManager(null);
				game.setAbout(new About(game));
				State.setState(new About(game));
			}
		}));
		
		uiManager.addObject(new UIImageButton(370, 380, 88, 40, Assets.exit_array, new ClickListener() {
			@Override
			public void onClick() {
				game.getMouseManager().setUIManager(null);
				System.exit(1);
			}
		}));
	}
	
	@Override
	public void tick() {
		uiManager.tick();
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.titleGame, 0, 0, null);
		uiManager.render(g);
	}
}
