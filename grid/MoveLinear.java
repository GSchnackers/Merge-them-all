package com.pipon.mergeemall.grid;

public class MoveLinear extends MovingBehaviour {

	public MoveLinear(Tile parent) {
		super(parent);
	}

	@Override
	public void move(Direction dir) {
		parent.setMover(new MoveCases(parent, Integer.MAX_VALUE));
		parent.move(dir);
		parent.setMover(this);
	}

	public MovingType getMovingType() {
		return MovingType.SLIDING;
	}

}
