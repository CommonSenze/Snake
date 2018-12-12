package me.commonsenze.Snake;

import java.awt.Graphics;
import java.util.ArrayList;

import me.commonsenze.Snake.Objects.Snake;
import me.commonsenze.Snake.Util.Renderable;

public class Game {

	private ArrayList<Renderable> renderables = new ArrayList<>(), remove = new ArrayList<>();
	private Snake snake;
	public static boolean STARTED = false;

	public Game() {
		this.snake = new Snake(Main.FIELD_SIZE*7,Main.FIELD_SIZE*7);
		renderables.add(snake);
	}

	public void render(Graphics g) {
		for (Renderable renderable : renderables) {
			renderable.render(g);
		}
		renderables.removeAll(remove);
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
	
	public Snake getHead() {
		return snake;
	}
}
