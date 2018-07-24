package com.pipon.mergeemall.grid;

public abstract class MovingBehaviour {
	protected Tile parent;
	protected boolean isDone;
	
	public MovingBehaviour(Tile parent){
		this.parent = parent;
		isDone = false;
	}
	
	public abstract void move(Direction dir);
	public abstract MovingType getMovingType();


	public boolean isDone() {
		return isDone;
	}

}
