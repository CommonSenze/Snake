package me.commonsenze.Snake.Util;

import java.util.ArrayList;

public enum Grid {

	A1,A2,A3,A4,A5,A6,A7,A8,
	B1,B2,B3,B4,B5,B6,B7,B8,
	C1,C2,C3,C4,C5,C6,C7,C8,
	D1,D2,D3,D4,D5,D6,D7,D8,
	E1,E2,E3,E4,E5,E6,E7,E8,
	F1,F2,F3,F4,F5,F6,F7,F8,
	G1,G2,G3,G4,G5,G6,G7,G8,
	H1,H2,H3,H4,H5,H6,H7,H8;

	public static Grid getSection(String section) {
		for (Grid grid : Grid.values()) {
			if (grid.name().equalsIgnoreCase(section))return grid;
		}
		return null;
	}

	public static ArrayList<Grid> getKingSections(Team team){
		ArrayList<Grid> grids = new ArrayList<>();

		String section = (team == Team.BLACK ? "H": "A");
		
		for (int i = 1; i <= 8; i++) {
			grids.add(getSection(section+i));
		}
		return grids;
	}

	public ArrayList<Grid> getAdjacents(){
		ArrayList<Grid> adjacents = new ArrayList<>();
		char letter = this.name().charAt(0);
		int number = Integer.parseInt(this.name().substring(1));

		for (Grid grid : Grid.values()) {
			int letterDifference = Math.abs(letter - grid.name().charAt(0));
			int numberDifference = Math.abs(number - Integer.parseInt(grid.name().substring(1)));
			if (letterDifference == 1&& numberDifference == 1) {
				adjacents.add(grid);
			}
		}
		return adjacents;
	}

	public ArrayList<Grid> getDoubleAdjacents(){
		ArrayList<Grid> adjacents = new ArrayList<>();
		char letter = this.name().charAt(0);
		int number = Integer.parseInt(this.name().substring(1));

		for (Grid grid : Grid.values()) {
			int letterDifference = Math.abs(letter - grid.name().charAt(0));
			int numberDifference = Math.abs(number - Integer.parseInt(grid.name().substring(1)));
			if (letterDifference == 2&& numberDifference == 2) {
				adjacents.add(grid);
			}
		}
		return adjacents;
	}

	public Grid getAverage(Grid grid) {
		char firstLetter = this.name().charAt(0);
		int firstNumber = Integer.parseInt(this.name().substring(1));

		char secondLetter = grid.name().charAt(0);
		int secondNumber = Integer.parseInt(grid.name().substring(1));

		char newLetter = (char) ((secondLetter+firstLetter)/2);
		int newNumber = (secondNumber + firstNumber)/2;

		return Grid.getSection(""+newLetter+newNumber);
	}
}
