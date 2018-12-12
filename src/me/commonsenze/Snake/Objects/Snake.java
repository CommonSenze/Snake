package me.commonsenze.Snake.Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import me.commonsenze.Snake.Main;
import me.commonsenze.Snake.Util.Direction;
import me.commonsenze.Snake.Util.Renderable;

public class Snake implements Renderable {

	private int x, y, movementTimer;
	private int[] coords;
	private Rectangle head;
	private Direction currentDirection;

	public Snake(int x, int y) {
		this.head = new Rectangle(x, y, Main.FIELD_SIZE, Main.FIELD_SIZE);
		this.coords = new int[2];
		this.coords[0] = x/Main.FIELD_SIZE;
		this.coords[1] = y/Main.FIELD_SIZE;
		currentDirection = Direction.NORTH;
	}

	public void tick() {
		movementTimer++;
		if (movementTimer % 30 == 0) {
			move();
			rebuild();
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(head.x, head.y, head.width, head.height);
	}

	private void move() {
		switch(currentDirection) {
		case NORTH:
			y -= Main.FIELD_SIZE;
			coords[1]--;
			break;
		case SOUTH:
			y += Main.FIELD_SIZE;
			coords[1]++;
			break;
		case EAST:
			x += Main.FIELD_SIZE;
			coords[0]++;
			break;
		case WEST:
			x -= Main.FIELD_SIZE;
			coords[0]--;
			break;
		default:
			break;
		}
		
	}

	/**
	 * This method sets the x of the object, independent of the character that is rendered.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * This method returns the integer x of the object, separate of the characters x.
	 */
	public int getX() {
		return x;
	}

	/**
	 * This method returns the integer y of the object, separate of the characters y.
	 */
	public int getY() {
		return y;
	}

	/**
	 * This method sets the y of the object, independent of the character that is rendered.
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * This method is used to realign the rectangles X and Y with the actual X and Y of the class.
	 * We have both X and Y's separate so we can do a check to see if the next location of the X and Y of the class
	 * Falls into a hitbox shown in the gravity and walk method. If the X or Y is inside another hitbox,
	 * we pull the character back and realign the character after.
	 */
	public void rebuild() {
		getHead().setLocation(getX(), getY());
	}
	
	public int[] getCoords() {
		return coords;
	}

	public Rectangle getHead() {
		return head;
	}
}
