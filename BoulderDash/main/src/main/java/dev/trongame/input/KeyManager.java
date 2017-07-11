package dev.trongame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean[] keys;
	public boolean left1, right1, left2, right2;
	
	public KeyManager(){
		keys = new boolean [256];
	}
	
	public void tick(){
		left1 = keys[KeyEvent.VK_LEFT];
		right1 = keys[KeyEvent.VK_RIGHT];
		//left2 = keys[KeyEvent.VK_W];
		//right2 = keys[KeyEvent.VK_D];
	}
	
	public void tick1(){
		left2 = keys[KeyEvent.VK_Q];
		right2 = keys[KeyEvent.VK_D];
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
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

}
