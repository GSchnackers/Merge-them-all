package com.pipon.mergeemall.grid;

public class Grid {
	private int size;
	private int score;
	private Tile[][] grid;
	
	public Grid(int size) {
		this.size = size;
		score = 0;
		grid = new Tile[size][size];
	}
	
	public void move(int xFrom, int yFrom) {
		Tile tmp = getTile(xFrom, yFrom);
		remove(xFrom, yFrom);
		add(tmp);
	}

	public void moveAll(Direction direction) {

	}
	
 	public Tile getTile(int posX, int posY) {
		if(posX >= size || posX < 0 || posY >= size || posY < 0)
			return null;
		return grid[posX][posY];
	}
	
	public void add(Tile tile) {
		grid[tile.getPosX()][tile.getPosY()] = tile;
	}
	
	public void remove(int posX, int posY) {
		grid[posX][posY] = null;
	}
	
	public void remove(Tile tile) {
		grid[tile.getPosX()][tile.getPosY()] = null;
	}

	public String toString() {
		String text = "";
		for(int y = 0; y < size; y++) {
			for(int x = 0; x < size; x++) {
				if(grid[x][y] != null)
					text = text+grid[x][y].toString()+" ";
				else
					text = text+"- ";
			}
			text = text+"\n";
		}
		return text;
	}
}
