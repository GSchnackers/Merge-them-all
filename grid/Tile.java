package com.pipon.mergeemall.grid;

import com.pipon.mergeemall.view.EffectDestroy;
import com.pipon.mergeemall.view.EffectFall;
import com.pipon.mergeemall.view.TileView;
import com.pipon.mergeemall.math.Vector3i;

public abstract class Tile {
	protected int posX, posY;
	protected MovingBehaviour mover;
	protected CollidingBehaviour collider;
	protected Grid grid;
	protected boolean isMoving;
	protected boolean selected;
	protected boolean isClickable;
	protected boolean isDestroyed;
	protected TileView tileView;
	
	public Tile(Grid grid, int posX, int posY) {
		this.grid = grid;
		this.posX = posX;
		this.posY = posY;
		isMoving = false;
		mover = null;
		collider = null;
		selected = false;
		isClickable = false;
		isDestroyed = false;
	}
	
	public void move(Direction dir) {

		MovingType movingType = null;
		Vector3i from = null;
		MovingBehaviour first = null;

		/*
		Pour ne prendre en compte que le premier mover et pas les intermédiaires..
		 */
		if(!isMoving) {
			movingType = mover.getMovingType();
			from = new Vector3i(posX, posY, 0);
			first = mover;
		}

		if(mover != null) {
			isMoving = true;
			mover.move(dir);
			if(first.isDone())
				tileView.move(new Vector3i(posX - from.x, posY - from.y, 0), movingType);
		}
	}

	public boolean isDestroyed() {
		return isDestroyed;
	}
	
	public void collide(Tile tile, Direction direction) {
		if(collider != null && tile != null)
			collider.collide(tile, direction);
	}
	
	public Tile getCollider(Direction dir) {
		return grid.getTile(posX + dir.getDx(), posY + dir.getDy());
	}

	public Tile getCollider(Direction dir, int movementSize) {
		return grid.getTile(posX + (dir.getDx()) * movementSize, posY + (dir.getDy()) * movementSize);
	}
	
	public void destroy(boolean fall) {
		isMoving = false;
		isDestroyed = true;
		grid.remove(this);
		if(fall)
			tileView.setEffect(new EffectFall(tileView));
		else
			tileView.setEffect(new EffectDestroy(tileView));
	}
	
	public void setClickable(boolean clickable) {
		isClickable = clickable;
	}
	
	public void setSelected(boolean selected) {
		if(isClickable)
			this.selected = selected;
	}
	
	public void setLocation(int posX, int posY) {
		int tPosX = this.posX;
		int tPosY = this.posY;
		this.posX = posX;
		this.posY = posY;
		
		grid.move(tPosX, tPosY);
	}
	
	public void setMover(MovingBehaviour mover) {
		this.mover = mover;
	}

	public void setMoving(boolean isMoving) { this.isMoving = isMoving; }

	public boolean isSelected() {
		return selected;
	}
	
	public boolean isMoving() {
		return isMoving;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
}
