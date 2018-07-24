package com.pipon.mergeemall.grid;

public class BoostLevel extends CollideBoost {

	public BoostLevel(TileBoost parent, int boost) {
		super(parent, boost);
	}

	@Override
	public void boost(TileScore tile) {
		tile.incrementLevel(boost);
		System.out.println("BOOST BITCH "+tile.getLevel());
	}

}
