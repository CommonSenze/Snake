package me.commonsenze.Snake.Util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import me.commonsenze.Snake.Game;
import me.commonsenze.Snake.Main;

public class UserKeyInput extends KeyAdapter {

	private Game game;
	
	public UserKeyInput(Game game) {
		this.game = game;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_W) {
			game.getHead().setDirection(-5);
		}
		if (key == KeyEvent.VK_A) {
			Main.CAMERA.setXSpeed(-5);
		}
		if (key == KeyEvent.VK_D) {
			Main.CAMERA.setXSpeed(5);
		}
		if (key == KeyEvent.VK_S) {
			Main.CAMERA.setYSpeed(5);
		}
	}
}
