package me.commonsenze.Snake.Util;

import java.awt.Graphics;

public interface Renderable {
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
}
