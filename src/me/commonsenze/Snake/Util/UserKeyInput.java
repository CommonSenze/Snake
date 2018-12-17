package me.commonsenze.Snake.Util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import me.commonsenze.Snake.Game;

public class UserKeyInput extends KeyAdapter {

	private Game game;
	
	public UserKeyInput(Game game) {
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (!Game.STARTED)Game.STARTED = true;
		if (!game.getHead().hasMoved()) return;
		if (key == KeyEvent.VK_W) {
			if (game.getHead().getDirection() == Direction.SOUTH)return;
			game.getHead().setDirection(Direction.NORTH);
			game.getHead().setMoved(false);
		}
		if (key == KeyEvent.VK_A) {
			if (game.getHead().getDirection() == Direction.EAST)return;
			game.getHead().setDirection(Direction.WEST);
			game.getHead().setMoved(false);
		}
		if (key == KeyEvent.VK_D) {
			if (game.getHead().getDirection() == Direction.WEST)return;
			game.getHead().setDirection(Direction.EAST);
			game.getHead().setMoved(false);
		}
		if (key == KeyEvent.VK_S) {
			if (game.getHead().getDirection() == Direction.NORTH)return;
			game.getHead().setDirection(Direction.SOUTH);
			game.getHead().setMoved(false);
		}
	}
}
