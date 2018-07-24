package com.pipon.mergeemall.grid;

public class CollideMerge implements CollidingBehaviour {

	private TileScore parent;

	public CollideMerge(TileScore parent) {
		this.parent = parent;
	}

	@Override
	public void collide(Tile tile, Direction direction) {
		if(((TileScore) tile).getLevel() == parent.getLevel()) {
			tile.destroy(false);
			parent.incrementLevel();
		} else {
			tile.setMoving(false);
		}
	}
}
