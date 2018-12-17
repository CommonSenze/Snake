package me.commonsenze.Snake.Util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import me.commonsenze.Snake.Game;
import me.commonsenze.Snake.Main;

public class UserMouseInput  extends MouseAdapter {

	@Override
	public void mouseClicked(MouseEvent e) {
		if (!Game.STARTED)Game.STARTED = true;
	}

	public void render(Graphics g) {
		if (!Game.STARTED) {
			g.setColor(Color.ORANGE);
			g.setFont(new Font(g.getFont().getFontName(), 20, 30));
			g.fillRect(Main.WIDTH/3, Main.HEIGHT*10/24, Main.WIDTH/3, 100);
			g.setColor(Color.BLACK);
			g.drawString("Click To Start", (Main.WIDTH/3)+((Main.WIDTH/3)/2)-95, (Main.HEIGHT*10/24)+55);
		}
	}
}
