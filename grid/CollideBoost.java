package com.pipon.mergeemall.grid;

public abstract class CollideBoost implements CollidingBehaviour {

	protected TileBoost parent;
	protected int boost;

	public CollideBoost(TileBoost parent, int boost) {
		this.parent = parent;
		this.boost = boost;
	}

	@Override
	public void collide(Tile tile, Direction direction){
		boost((TileScore)tile);
		parent.destroy(false);
	}
	
	public abstract void boost(TileScore tile);
}
