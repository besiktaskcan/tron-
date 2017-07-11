package dev.trongame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import dev.trongame.input.KeyManager;
import dev.trongame.states.State;
import dev.trongame.states.GameState;
import dev.trongame.states.MenuState;
import dev.trongame.display.Fenetre;
import dev.trongame.gfx.Assets;

public class Game implements Runnable{

private Fenetre display;
	
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	public BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	private State menuState;
	
	//Input
	private KeyManager keyManager;
	
	//Handler 
	//private Handler handler;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	private void init(){
		display = new Fenetre(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		//handler = new Handler(this);
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(gameState);
	}
	
	//private int x = 15;
	//private int y = 368;
	
	private void tick(){
		//y -= 1;
		keyManager.tick();
		keyManager.tick1();
		
		if(State.getState() != null)
			State.getState().tick();
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		//g.clearRect(0, 0, width, height);
		//Draw Here
		
		if(State.getState() != null)
			State.getState().render(g);
		
		//g.drawImage(Assets.player1, 238, y, null);
		//g.drawImage(Assets.player2, 330, y, null);
		
		//End Drawing
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		
		int fps = 30;
		double timePerTick = 2000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		long ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now -lastTime;
			lastTime = now;
			
			if(delta >= 2){
				tick();
				render();
				ticks ++;
				delta --;
			}
			if(timer >= 2000000000){
				System.out.println("Ticks and frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
		
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
