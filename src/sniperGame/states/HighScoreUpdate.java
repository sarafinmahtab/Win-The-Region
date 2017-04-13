package sniperGame.states;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import sniperGame.gfx.Utils;

/**
 * @author Arafin
 *
 */

public class HighScoreUpdate {

	private int[] score = new int[10];
	private File text;
	
	public void updateScore(int highScore, int level) {

		String file = Utils.loadFileAsString("res/HighScore/Score.txt"); //Reads the file
		String[] tokens = file.split("\\s+");
		score[0] = Utils.parseInt(tokens[0]); //Gets the score value
		score[1] = Utils.parseInt(tokens[1]);
		
		if(level == 1) {
			if (highScore > score[0]) {
				score[0] = highScore;
				
				text = new File("res/HighScore/Score.txt");
				
				//Writes the new highscore into the file
				try (Writer writer = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(text), "utf-8"))) {
					writer.write(Integer.toString(score[0]) + " " + Integer.toString(score[1]));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		} else if(level == 2) {
			if (highScore > score[1]) {
				score[1] = highScore;
				
				text = new File("res/HighScore/Score.txt");
				
				//Writes the new highscore into the file
				try (Writer writer = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(text), "utf-8"))) {
					writer.write(Integer.toString(score[0]) + " " + Integer.toString(score[1]));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
	}
	
	public int getHighScore() {
		return score[0];
	}
	
	public int getHighScore2() {
		return score[1];
	}
}
