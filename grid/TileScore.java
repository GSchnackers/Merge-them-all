package com.pipon.mergeemall.grid;

public class TileScore extends Tile {
	private int level;
	private int colour;
	private int stars;
	private int score;
	
	public TileScore(Grid grid, int posX, int posY, int level) {
		super(grid, posX, posY);
		mover = new MoveLinear(this);
		collider = new CollideMerge(this);
		this.level = level;
		computeScore();
	}
	
	public void computeScore() {

	}

	public int getScore() {
		return score;
	}

	public void incrementLevel() {
		level++;
		computeScore();
	}

	public void incrementLevel(int dLevel) {
		level += dLevel;
		computeScore();
	}

	public int getLevel() {
		return level;
	}

	public String toString() {
		return ""+level;
	}
}
