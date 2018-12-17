package me.commonsenze.Snake.Scenes.Enum;

import me.commonsenze.Snake.Scenes.Game;
import me.commonsenze.Snake.Scenes.GameOver;
import me.commonsenze.Snake.Util.Renderable;

public enum Scene {

	GAME(new Game()),
	GAME_OVER(new GameOver());
	
	private Renderable renderable;
	
	private Scene(Renderable renderable) {
		this.renderable = renderable;
	}
	
	public Renderable getScene() {
		return renderable;
	}
}
