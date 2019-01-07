package me.commonsenze.Snake.Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import me.commonsenze.Snake.Main;
import me.commonsenze.Snake.Scenes.Game;
import me.commonsenze.Snake.Util.Direction;
import me.commonsenze.Snake.Util.Renderable;

public class Snake implements Renderable {

	private int x, y, movementTimer;
	private Integer[] coords;
	private Rectangle head;
	private Direction currentDirection;
	private int length;
	private ArrayList<Body> bodies;
	private Food food;
	private Game game;
	private boolean moved;

	public Snake(int x, int y, Game game) {
		this.head = new Rectangle(x, y, Main.FIELD_SIZE, Main.FIELD_SIZE);
		this.coords = new Integer[2];
		this.x = x;
		this.y = y;
		this.coords[0] = x/Main.FIELD_SIZE;
		this.coords[1] = y/Main.FIELD_SIZE;
		currentDirection = Direction.NORTH;
		this.bodies = new ArrayList<>();
		this.length = 0;
		this.game = game;
	}

	public void tick() {
		movementTimer++;
		if (movementTimer % 10 == 0) {
			move();
			checkGrid();
			rebuild();
			moved = true;
			movementTimer = 0;
		}
	}

	public void render(Graphics g) {
		for (Body body : bodies) {
			body.render(g);
		}
		if (food != null) {
			food.render(g);
		}
		g.setColor(Color.WHITE);
		g.fillRect(head.x, head.y, head.width, head.height);
	}

	private void move() {
		switch(currentDirection) {
		case NORTH:
			y -= Main.FIELD_SIZE;
			break;
		case SOUTH:
			y += Main.FIELD_SIZE;
			break;
		case EAST:
			x += Main.FIELD_SIZE;
			break;
		case WEST:
			x -= Main.FIELD_SIZE;
			break;
		default:
			break;
		}
	}

	private void checkGrid() {
		ArrayList<Body> prevBodies = new ArrayList<>(bodies);
		for (Body body : prevBodies) {
			if (body.inGrid(coords)) {
				System.out.println("You're dead");
			}
		}
		int prevX = coords[0]*Main.FIELD_SIZE, prevY = coords[1]*Main.FIELD_SIZE;

		reloadLocation();

		if (game.inFoodGrid(coords)) {
			length++;
			game.spawnFood(coords);
		}
		if (length >= 1) {
			bodies.add(new Body(prevX,prevY, this));
		}
		for (Body body : prevBodies) {
			body.incrementMovement();
		}
	}

	public void setMoved(boolean moved) {
		this.moved = moved;
	}

	public boolean hasMoved() {
		return moved;
	}

	public boolean inGrid(Integer[] coords) {
		for (Body body : bodies) {
			if (body.inGrid(coords))return true;
		}
		return coords[0] == this.coords[0] && this.coords[1] == coords[1];
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

	public void reloadLocation() {
		this.coords[0] = x/Main.FIELD_SIZE;
		this.coords[1] = y/Main.FIELD_SIZE;
	}

	public Integer[] getCoords() {
		return coords;
	}

	public Rectangle getHead() {
		return head;
	}

	public Direction getDirection() {
		return currentDirection;
	}

	public void setDirection(Direction direction) {
		currentDirection = direction;
	}

	public int getLength() {
		return length;
	}

	public void removeBody(Body body) {
		bodies.remove(body);
	}
}
