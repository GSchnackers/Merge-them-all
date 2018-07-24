package com.pipon.mergeemall.grid;

public class TileBlock extends Tile {

	public TileBlock(Grid grid, int posX, int posY) {
		super(grid, posX, posY);
		mover = null;
		collider = new CollideSolid();
	}

	public String toString() {
		return "X";
	}
}