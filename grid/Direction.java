package com.pipon.mergeemall.grid;

public enum Direction {
	
	NORTH(-1, -1),
	SOUTH(1, 1),
	NORTH_EAST(0, -1),
	NORTH_WEST(-1, 0),
	SOUTH_EAST(1, 0),
	SOUTH_WEST(0, 1);
	
	private int dx;
	private int dy;
	
	private Direction(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public int getDx() {
		return dx;
	}
	
	public int getDy() {
		return dy;
	}
}
