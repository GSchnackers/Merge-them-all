package com.pipon.mergeemall.grid;

public class MoveCases extends MovingBehaviour {
	private int moveSize;
	
	public MoveCases(Tile parent, int moveSize) {
		super(parent);
		this.moveSize = moveSize;
	}

	@Override
	public void move(Direction dir) {
		int i;
		for(i = 1; i <= moveSize && parent.isMoving(); i++) {
			if(parent.getCollider(dir,i) != null)
				parent.getCollider(dir, i).collide(parent, dir);
		}

		if(!parent.isDestroyed()) {
			if (parent.isMoving())
				parent.setLocation(parent.getPosX() + (dir.getDx() * (i - 1)), parent.getPosY() + (dir.getDy() * (i - 1)));
			else
				parent.setLocation(parent.getPosX() + (dir.getDx() * (i - 2)), parent.getPosY() + (dir.getDy() * (i - 2)));
		}
	}

	public MovingType getMovingType() {
		return MovingType.SLIDING;
	}

}
