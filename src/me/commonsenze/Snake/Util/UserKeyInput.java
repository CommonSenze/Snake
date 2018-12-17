package me.commonsenze.Snake.Util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import me.commonsenze.Snake.Scenes.Game;

public class UserKeyInput extends KeyAdapter {

	private Game game;

	public UserKeyInput(Game game) {
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (!Game.STARTED)Game.STARTED = true;
		if (game.getPlayerOne().hasMoved()) {
			if (key == KeyEvent.VK_W) {
				if (game.getPlayerOne().getDirection() == Direction.SOUTH)return;
				game.getPlayerOne().setDirection(Direction.NORTH);
				game.getPlayerOne().setMoved(false);
			}
			if (key == KeyEvent.VK_A) {
				if (game.getPlayerOne().getDirection() == Direction.EAST)return;
				game.getPlayerOne().setDirection(Direction.WEST);
				game.getPlayerOne().setMoved(false);
			}
			if (key == KeyEvent.VK_D) {
				if (game.getPlayerOne().getDirection() == Direction.WEST)return;
				game.getPlayerOne().setDirection(Direction.EAST);
				game.getPlayerOne().setMoved(false);
			}
			if (key == KeyEvent.VK_S) {
				if (game.getPlayerOne().getDirection() == Direction.NORTH)return;
				game.getPlayerOne().setDirection(Direction.SOUTH);
				game.getPlayerOne().setMoved(false);
			}
		}
		if (game.getPlayerTwo().hasMoved()) {
			if (key == KeyEvent.VK_UP) {
				if (game.getPlayerTwo().getDirection() == Direction.SOUTH)return;
				game.getPlayerTwo().setDirection(Direction.NORTH);
				game.getPlayerTwo().setMoved(false);
			}
			if (key == KeyEvent.VK_LEFT) {
				if (game.getPlayerTwo().getDirection() == Direction.EAST)return;
				game.getPlayerTwo().setDirection(Direction.WEST);
				game.getPlayerTwo().setMoved(false);
			}
			if (key == KeyEvent.VK_RIGHT) {
				if (game.getPlayerTwo().getDirection() == Direction.WEST)return;
				game.getPlayerTwo().setDirection(Direction.EAST);
				game.getPlayerTwo().setMoved(false);
			}
			if (key == KeyEvent.VK_DOWN) {
				if (game.getPlayerTwo().getDirection() == Direction.NORTH)return;
				game.getPlayerTwo().setDirection(Direction.SOUTH);
				game.getPlayerTwo().setMoved(false);
			}
		}
	}
}
