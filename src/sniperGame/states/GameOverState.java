package sniperGame.states;

import java.awt.Graphics;

import sniperGame.Game;
import sniperGame.gfx.Assets;
import sniperGame.ui.ClickListener;
import sniperGame.ui.UIImageButton;
import sniperGame.ui.UIManager2;

/**
 * @author Arafin
 *
 */

public class GameOverState extends State {
	
	private UIManager2 uiManager2;
	private GameStatus gameStatus;
	
	public GameOverState(Game game, int level) {
		super(game);
		
		gameStatus = new GameStatus(game, level);
		
		uiManager2 = new UIManager2(game);
		game.getMouseManager().setUIManager2(uiManager2);
		
		uiManager2.addObject(new UIImageButton(235, 350, 90, 48, Assets.menu_array, new ClickListener() {
			@Override
			public void onClick() {
				game.getMouseManager().setUIManager2(null);
				game.setMenuState(new MenuState(game));
				State.setState(game.getMenuState());
			}
		}));
		
		uiManager2.addObject(new UIImageButton(353, 350, 128, 48, Assets.restart_array, new ClickListener() {
			@Override
			public void onClick() {
				if(level == 1) {
					game.getMouseManager().setUIManager2(null);
					game.setGameState(new GameState(game));
					State.setState(game.getGameState());
				} else if(level == 2) {
					game.getMouseManager().setUIManager2(null);
					game.setGameState2(new GameState2(game));
					State.setState(game.getGameState2());
				}
			}
		}));
		
		uiManager2.addObject(new UIImageButton(507, 350, 90, 48, Assets.exit_array, new ClickListener() {
			@Override
			public void onClick() {
				game.getMouseManager().setUIManager2(null);
				game.setGameState(new GameState(game));
				game.setGameState2(new GameState2(game));
				System.exit(1);
			}
		}));
		
		if(level == 1 && GameState.won == true) {
			uiManager2.addObject(new UIImageButton(312, 420, 210, 48, Assets.next_array, new ClickListener() {
				@Override
				public void onClick() {
					game.getMouseManager().setUIManager2(null);
					game.setGameState(new GameState(game));
					game.setGameState2(new GameState2(game));
					State.setState(game.getGameState2());
				}
			}));
		}
	}
	
	@Override
	public void tick() {
		gameStatus.tick();
		uiManager2.tick();
	}
	
	@Override
	public void render(Graphics g) {
		gameStatus.render(g);
		uiManager2.render(g);
	}
}
