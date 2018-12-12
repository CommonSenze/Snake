package me.commonsenze.Snake.Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import me.commonsenze.Snake.Main;
import me.commonsenze.Snake.Util.Renderable;

public class Body implements Renderable {

	private int timeAlive;
	private Integer[] coords;
	private Rectangle body;
	private Snake head;
	
	public Body(int x, int y, Snake head) {
		this.body = new Rectangle(x, y, Main.FIELD_SIZE, Main.FIELD_SIZE);
		this.coords = new Integer[2];
		this.coords[0] = x/Main.FIELD_SIZE;
		this.coords[1] = y/Main.FIELD_SIZE;
		timeAlive = 0;
		this.head = head;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(body.x, body.y, body.width, body.height);
	}
	
	public void incrementMovement() {
		timeAlive++;
		if (timeAlive == head.getLength()) {
			head.removeBody(this);
		}
	}
	
	public boolean inGrid(Integer[] coords) {
		return coords[0] == this.coords[0] && this.coords[1] == coords[1];
	}
	
	public Integer[] getCoords() {
		return coords;
	}
}
