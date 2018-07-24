package com.pipon.mergeemall.grid;

public class CollideSolid implements CollidingBehaviour {

	@Override
	public void collide(Tile tile, Direction direction) {
		tile.setMoving(false);
	}

}
