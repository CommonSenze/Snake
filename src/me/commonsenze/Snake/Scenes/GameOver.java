package me.commonsenze.Snake.Scenes;

import java.awt.Font;
import java.awt.Graphics;

import me.commonsenze.Snake.Util.Renderable;

public class GameOver implements Renderable {

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.setFont(new Font("Baskerville",25, 70));
		g.drawString("Game Over", 200, 100);
	}
}
