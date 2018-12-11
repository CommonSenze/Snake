package me.commonsenze.Snake.Util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import me.commonsenze.Platformer.Main;

public class UserKeyInput extends KeyAdapter {

	public UserKeyInput() {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_W) {
			Main.CAMERA.setYSpeed(-5);
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
