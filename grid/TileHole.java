package com.pipon.mergeemall.grid;

public class TileHole extends Tile {

	public TileHole(Grid grid, int posX, int posY) {
		super(grid, posX, posY);
		mover = null;
		collider = new CollideDestroy();
	}

	public String toString() {
		return "O";
	}

	public void addWall(Direction dir) {
		if(collider instanceof  CollideDestroy)
			((CollideDestroy) collider).addWall(dir);
	}
}
