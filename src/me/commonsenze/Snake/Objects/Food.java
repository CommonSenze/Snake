package me.commonsenze.Snake.Objects;

import java.awt.Color;
import java.awt.Graphics;

import me.commonsenze.Snake.Main;
import me.commonsenze.Snake.Util.Renderable;

public class Food implements Renderable {

	private int x, y;
	private Integer[] coords;
	
	public Food(int x, int y) {
		this.x = x;
		this.y = y;
		this.coords = new Integer[2];
		this.coords[0] = x/Main.FIELD_SIZE;
		this.coords[1] = y/Main.FIELD_SIZE;
	}

	@Override
	public void tick() {}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(x, y, Main.FIELD_SIZE, Main.FIELD_SIZE);
	}
	
	public boolean inGrid(Integer[] coords) {
		return coords[0] == this.coords[0] && this.coords[1] == coords[1];
	}
	
	public static void main(String[] args) {
		String message = "\t\tHello:";
		
		System.out.println(message.trim().replace(":", ""));
	}
}
