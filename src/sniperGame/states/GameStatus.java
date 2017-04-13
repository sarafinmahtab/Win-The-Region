package sniperGame.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import sniperGame.Game;
import sniperGame.gfx.Assets;

/**
 * @author Arafin
 *
 */

public class GameStatus extends State {

	private HighScoreUpdate highScoreUpdate;
	
	private int level;
	
	public GameStatus(Game game, int level) {
		super(game);
		this.level = level;
		highScoreUpdate = new HighScoreUpdate();
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.background, 0, 0, null);
		g.drawImage(Assets.game_over, 236, 130, null);
		
		if(level == 1) {
			if(GameState.won) {
				g.setFont(new Font("Chaparral Pro Light", Font.BOLD, 22));
				g.setColor(Color.white);
				g.drawString("You've won the region 1", 283, 225);
				g.drawString("Score: " + GameState.score, 283, 251);
				highScoreUpdate.updateScore(GameState.score, level);
				g.drawString("Highest Score: " + highScoreUpdate.getHighScore(), 283, 277);
			} else {
				g.setFont(new Font("Chaparral Pro Light", Font.BOLD, 22));
				g.setColor(Color.white);
				g.drawString("You've lost the region 1", 283, 225);
				g.drawString("Score: " + GameState.score, 283, 251);
				highScoreUpdate.updateScore(GameState.score, level);
				g.drawString("Highest Score: " + highScoreUpdate.getHighScore(), 283, 277);
			}
		} else if(level == 2) {
			if(GameState2.won2) {
				g.setFont(new Font("Chaparral Pro Light", Font.BOLD, 22));
				g.setColor(Color.white);
				g.drawString("You've won the region 2", 283, 225);
				g.drawString("Score: " + GameState2.score2, 283, 251);
				highScoreUpdate.updateScore(GameState2.score2, level);
				g.drawString("Highest Score: " + highScoreUpdate.getHighScore2(), 283, 277);
			} else {
				g.setFont(new Font("Chaparral Pro Light", Font.BOLD, 22));
				g.setColor(Color.white);
				g.drawString("You've lost the region 2", 283, 225);
				g.drawString("Score: " + GameState2.score2, 283, 251);
				highScoreUpdate.updateScore(GameState2.score2, level);
				g.drawString("Highest Score: " + highScoreUpdate.getHighScore2(), 283, 277);
			}
		}
	}
}
