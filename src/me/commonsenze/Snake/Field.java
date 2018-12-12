package me.commonsenze.Snake;

import java.awt.Graphics;

public class Field {

	public Field() {
		
	}
	
	public void render(Graphics g) {
		for (int x = 0; x <32; x++) {
			for (int y = 0; y < 32; y++) {
				g.drawRect(x*Main.FIELD_SIZE, y*Main.FIELD_SIZE, Main.FIELD_SIZE, Main.FIELD_SIZE);
			}
		}
	}
}
