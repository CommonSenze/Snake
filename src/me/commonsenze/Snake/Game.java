package me.commonsenze.Snake;

import java.awt.Graphics;
import java.util.ArrayList;

import me.commonsenze.Snake.Objects.Snake;
import me.commonsenze.Snake.Util.Renderable;

public class Game {

	private ArrayList<Renderable> renderables = new ArrayList<>(), remove = new ArrayList<>();
	private Snake snake;

	public Game() {
		this.snake = new Snake();
	}

	public void render(Graphics g) {
		for (Renderable renderable : renderables) {
			renderable.render(g);
		}
		renderables.removeAll(remove);
	}
	
	public void tick() {
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
	
//	private void spawnCheckers() {
//		int slot = 0;
//		for (Rectangle rectangle : field.getRectangles()) {
//			if (slot == 12)break;
//			int x = 10+rectangle.x;
//			int y = 10+rectangle.y;
//			Pieve checker = new Checker(x, y, Team.BLACK, rectangle, field, this);
//			field.getCovered().put(field.getGrids().get(rectangle), checker);
//			this.renderables.add(checker);
//			slot++;
//		}
//		slot = 0;
//		ArrayList<Rectangle> otherSide = field.getRectangles();
//		Collections.reverse(otherSide);
//		for (Rectangle rectangle : otherSide) {
//			if (slot == 12)break;
//			int x = 10+rectangle.x;
//			int y = 10+rectangle.y;
//			Checker checker = new Checker(x, y, Team.RED, rectangle, field, this);
//			field.getCovered().put(field.getGrids().get(rectangle), checker);
//			this.renderables.add(checker);
//			slot++;
//		}
//	}
}
