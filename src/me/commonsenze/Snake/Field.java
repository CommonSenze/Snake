package me.commonsenze.Snake;

import java.awt.Color;
import java.awt.Graphics;

public class Field {

	public Field() {
		
	}
	
	public static void render(Graphics g) {
		g.setColor(new Color(100,100,100));
		for (int x = 0; x <Main.GRID_SLOTS; x++) {
			for (int y = 0; y < Main.GRID_SLOTS; y++) {
				g.drawRect(x*Main.FIELD_SIZE, y*Main.FIELD_SIZE, Main.FIELD_SIZE, Main.FIELD_SIZE);
			}
		}
	}
}
