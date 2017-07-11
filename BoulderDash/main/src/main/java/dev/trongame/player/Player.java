package dev.trongame.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import dev.trongame.Game;
import dev.trongame.gfx.Assets;
//import dev.trongame.tiles.Tile;

public class Player {

	protected float x;
	protected float y;
	
	// Color 1 = blue, color 2 = red
	protected int color;
	
	// Orientation 1 = north, Orientation 2 = east, Orientation 3 = south, Orientation 4 = west
	protected int orientation = 1;
	
	// Speed 
	protected int speed = 2;

	
	//public int health = 10;
	
	protected float xMove, yMove;
	
	protected int width, height;
	//protected Handler handler;
	private Game game;
	protected Rectangle bounds;
	
	public Player(Game game, float x, float y, int color){
		super();
		this.x = x;
		this.y = y;
		this.color = color;
		//this.handler = handler;
		this.game = game;
		xMove = 0;
		yMove = 0;
		
		bounds = new Rectangle(0, 0, width, height);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 16;
		bounds.height = 16;
	}
	
	//private int y = 350;
	
	public void tick(){
		
		  if(game.getKeyManager().left1){
			  if(orientation == 1){
				  orientation = 4;
			  }else{
				  orientation--;
			  }
		  }
		  
		  if(game.getKeyManager().right1){
			  if(orientation == 4){
				  orientation = 1;
			  }else{
				  orientation++;
			  }
		  }
		
		switch (orientation)
		{
		  case 1:
			y -= speed;
		    break;
		  case 2:
		    x += speed;
		    break;
		  case 3:
		    y += speed;
		    break;
		  case 4:
			x -= speed;
			break;
		  default:
		    System.out.println("Error in orientation");
		}
		
		
		
	}
	
	public void tick1(){
		
		  if(game.getKeyManager().left2){
			  if(orientation == 1){
				  orientation = 4;
			  }else{
				  orientation--;
			  }
		  }
		  
		  if(game.getKeyManager().right2){
			  if(orientation == 4){
				  orientation = 1;
			  }else{
				  orientation++;
			  }
		  }
		
		switch (orientation)
		{
		  case 1:
			y -= speed;
		    break;
		  case 2:
		    x += speed;
		    break;
		  case 3:
		    y += speed;
		    break;
		  case 4:
			x -= speed;
			break;
		  default:
		    System.out.println("Error in orientation");
		}
		
	}
	
	public void render(Graphics g){
		
		if(color == 1){
			g.drawImage(Assets.player1, (int) x, (int) y, null);
			g.setColor(Color.CYAN);
			g.fillRect((int) (x + bounds.x), (int) (y + bounds.y), bounds.width, bounds.height);
		}else{
			g.drawImage(Assets.player2, (int) x, (int) y, null);
			g.setColor(Color.MAGENTA);
			g.fillRect((int) (x + bounds.x), (int) (y + bounds.y), bounds.width, bounds.height);
		}
		
	}
	
	/*public void move(){
		moveX();
		moveY();
	}*/
	
	/*public void moveX(){
		if(xMove > 0){//Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
		}
		else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}
	}*/
	
	/*public void moveY(){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
		}
		else if(yMove > 0){//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}*/
	
	/*protected boolean collisionWithTile(int x, int y){
		return game.getWorld().getTile(x, y).isSolid();
	}*/
	
	
	//GETTERS SETTERS
	
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
