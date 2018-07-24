package com.pipon.mergeemall.grid;

public class TileBoost extends Tile {

	public TileBoost(Grid grid, int posX, int posY, int boost) {
		super(grid, posX, posY);
		mover = null;
		collider = new BoostLevel(this, boost);
	}

	public String toString() {
		return "B";
	}
}
