package me.commonsenze.Snake.Scenes;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import me.commonsenze.Snake.Field;
import me.commonsenze.Snake.Main;
import me.commonsenze.Snake.Objects.Food;
import me.commonsenze.Snake.Objects.Snake;
import me.commonsenze.Snake.Util.Renderable;

public class Game implements Renderable {

	private ArrayList<Renderable> renderables = new ArrayList<>(), remove = new ArrayList<>();
	private Snake playerOne, playerTwo;
	private Food[] food;
	public static boolean STARTED = false;

	public Game() {
		this.playerOne = new Snake(Main.FIELD_SIZE*3,Main.FIELD_SIZE*16, this);
		renderables.add(playerOne);
		
		this.playerTwo = new Snake(Main.FIELD_SIZE*28,Main.FIELD_SIZE*16, this);
		renderables.add(playerTwo);
		
		this.food = new Food[2];
		spawnFood();
	}

	public void render(Graphics g) {
		if (food[0] != null) {
			food[0].render(g);
		}
		
		if (food[1] != null) {
			food[1].render(g);
		}
		
		for (Renderable renderable : renderables) {
			renderable.render(g);
		}
		renderables.removeAll(remove);
		
		Field.render(g);
	}
	
	public void tick() {
		if (!STARTED)return;
		for (Renderable renderable : renderables) {
			renderable.tick();
		}
		renderables.removeAll(remove);
	}

	public void addRenderable(Renderable renderable) {
		renderables.add(renderable);
	}
	
	public void removeRenderable(Renderable renderable) {
		remove.add(renderable);
	}
	
	public void spawnFood(Integer[] coords) {
		if (food[0].inGrid(coords)) {
			Random random = new Random();
			int x = random.nextInt(Main.GRID_SLOTS/2);
			int y = random.nextInt(Main.GRID_SLOTS/2);
			
			Integer[] slot = {x,y};
			while (playerOne.inGrid(slot)||playerTwo.inGrid(slot)) {
				slot[0] = random.nextInt(Main.GRID_SLOTS/2);
				slot[1] = random.nextInt(Main.GRID_SLOTS/2);
			}
			
			food[0] = new Food(slot[0]*Main.FIELD_SIZE, slot[1]*Main.FIELD_SIZE);
		} else {
			Random random = new Random();
			int x = random.nextInt(Main.GRID_SLOTS/2)+(Main.GRID_SLOTS/2);
			int y = random.nextInt(Main.GRID_SLOTS/2)+(Main.GRID_SLOTS/2);
			
			Integer[] slot = {x,y};
			while (playerOne.inGrid(slot)||playerTwo.inGrid(slot)) {
				slot[0] = random.nextInt(Main.GRID_SLOTS/2)+(Main.GRID_SLOTS/2);
				slot[1] = random.nextInt(Main.GRID_SLOTS/2)+(Main.GRID_SLOTS/2);
			}
			
			food[1] = new Food(slot[0]*Main.FIELD_SIZE, slot[1]*Main.FIELD_SIZE);
		}
	}
	
	private void spawnFood() {
		Random random = new Random();
		int x = random.nextInt(Main.GRID_SLOTS/2);
		int y = random.nextInt(Main.GRID_SLOTS/2);
		
		int x1 = random.nextInt(Main.GRID_SLOTS/2)+(Main.GRID_SLOTS/2);
		int y1 = random.nextInt(Main.GRID_SLOTS/2)+(Main.GRID_SLOTS/2);
		
		Integer[] slot = {x,y};
		Integer[] slot1 = {x1,y1};
		while (playerOne.inGrid(slot)||playerTwo.inGrid(slot)) {
			slot[0] = random.nextInt(Main.GRID_SLOTS/2);
			slot[1] = random.nextInt(Main.GRID_SLOTS/2);
		}
		
		while (playerOne.inGrid(slot1)||playerTwo.inGrid(slot1)) {
			slot1[0] = random.nextInt(Main.GRID_SLOTS/2)+(Main.GRID_SLOTS/2);
			slot1[1] = random.nextInt(Main.GRID_SLOTS/2)+(Main.GRID_SLOTS/2);
		}
		
		food[0] = new Food(slot[0]*Main.FIELD_SIZE, slot[1]*Main.FIELD_SIZE);
		food[1] = new Food(slot1[0]*Main.FIELD_SIZE, slot1[1]*Main.FIELD_SIZE);
	}
	
	public boolean inFoodGrid(Integer[] coords) {
		return food[0].inGrid(coords)||food[1].inGrid(coords);
	}
	
	public Snake getPlayerOne() {
		return playerOne;
	}
	
	public Snake getPlayerTwo() {
		return playerTwo;
	}
}
