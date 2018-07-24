package com.pipon.mergeemall.grid;

import java.util.HashMap;

public class CollideDestroy implements CollidingBehaviour {

	private HashMap<Direction, Boolean> walls;

	public CollideDestroy() {
		walls = new HashMap<Direction, Boolean>();
		walls.put(Direction.NORTH, false);
		walls.put(Direction.NORTH_EAST, false);
		walls.put(Direction.NORTH_WEST, false);
		walls.put(Direction.SOUTH_EAST, false);
		walls.put(Direction.SOUTH_WEST, false);
		walls.put(Direction.SOUTH, false);
	}

	@Override
	public void collide(Tile tile, Direction direction) {
		if(!walls.get(direction))
			tile.destroy(true);
		else
			tile.setMoving(false);
	}
	
	public void addWall(Direction dir){
		walls.put(dir, true);
	}

	public void removeWall(Direction dir) {
		walls.put(dir, false);
	}

}
