package dev.trongame.states;

import java.awt.Graphics;

import dev.trongame.Game;
import dev.trongame.player.Player;

public class GameState extends State{

	private Player player1;
	private Player player2;
	
	//private World world;
	
	public GameState(Game game){
		super(game);
		//world = new World(handler, "res/worlds/world.txt");
		//handler.setWorld(world);
		player1 = new Player(game, 150, 350, 1);
		player2 = new Player(game, 350, 350, 2);
	}
	
	@Override
	public void tick() {
		//world.tick();
		player1.tick();
		player2.tick1();
	}

	@Override
	public void render(Graphics g) {
		//world.render(g);
		player1.render(g);
		player2.render(g);
	}

}
