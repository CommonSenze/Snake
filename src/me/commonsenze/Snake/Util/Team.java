package me.commonsenze.Snake.Util;

import java.awt.Color;

public enum Team {

	BLACK(Color.BLACK),
	RED(Color.RED);
	
	private Color color;
	
	private Team(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public Team getOppositeTeam() {
		return (this == BLACK ? RED : BLACK);
	}
}
