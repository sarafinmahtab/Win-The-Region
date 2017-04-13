package sniperGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Arafin
 *
 */

public class KeyManager implements KeyListener {
	
	private boolean[] keys;
	public boolean up, down, left, right, shot, enter;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		shot = keys[KeyEvent.VK_SPACE];
		enter = keys[KeyEvent.VK_ENTER];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		//System.out.println("Pressed!!");
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
