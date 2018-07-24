package com.pipon.mergeemall.view;

import com.badlogic.gdx.math.Vector3;
/**
 * Created by quentin on 11/23/17.
 */

public abstract class MovingView {

    private TileView tileView;

    public MovingView(TileView tileView) {
        this.tileView = tileView;
    }

    public abstract void move(Vector3 to);
}
