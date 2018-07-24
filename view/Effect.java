package com.pipon.mergeemall.view;

/**
 * Created by quentin on 11/23/17.
 */

public abstract class Effect {

    protected TileView tileView;

    public Effect(TileView tileView) {
        this.tileView = tileView;
    }

    public abstract void effects();
}
