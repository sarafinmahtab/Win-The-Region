package sniperGame.states;

import java.awt.Graphics;
import java.util.ArrayList;

import sniperGame.Game;

/**
 * @author Arafin
 *
 */

public abstract class State {

	private static State currentState = null;
	
	public static ArrayList<State> array_state = new ArrayList<>();

	public static void setState(State state){
		currentState = state;
		array_state.add(currentState);
	}
	
	public static State getState(){
		return currentState;
	}
	
	//CLASS
		
	protected Game game;
	
	public State(Game game){
		this.game = game;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
