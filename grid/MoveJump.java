package com.pipon.mergeemall.grid;

public class MoveJump extends MovingBehaviour {
	private int jumpSize;
	
	public MoveJump(Tile parent, int jumpSize) {
		super(parent);
		this.jumpSize = jumpSize;
		parent.setClickable(true);
	}
	
	@Override
	public void move(Direction dir) {
		if(parent.isSelected()) {
			parent.collide(parent.getCollider(dir, jumpSize), dir);
			if(parent.isMoving())
				parent.setLocation(parent.getPosX() + (dir.getDx() * jumpSize), parent.getPosY() + (dir.getDy() * jumpSize));
		} else {
			parent.setMover(new MoveLinear(parent));
			parent.move(dir);
			parent.setMover(this);
		}
	}

	public MovingType getMovingType() {
		return MovingType.TELEPORTING;
	}


}
