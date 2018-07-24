package com.pipon.mergeemall.view;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.pipon.mergeemall.grid.MovingType;
import com.pipon.mergeemall.math.Vector3i;
import com.badlogic.gdx.utils.Array;

public class TileView {

    private final float TILE_SIZE = 25.0f;

    protected ModelInstance instance;
    protected boolean isMoving;
    protected Vector3 location;
    protected Effect effect;
    private int gridSize;

    public TileView(int x, int y, int gridSize, Model model, Array<ModelInstance> instances) {
        effect = null;
        location = transformVector(new Vector3i(x, y, 0));
        this.gridSize = gridSize;
        instance = new ModelInstance(model, location);
        instance.calculateTransforms();
        instances.add(instance);
    }

    public void move(Vector3i to, MovingType movingType) {
        Vector3 fTo = transformVector(to);
    }

    public void effects() {
        if(effect != null)
            effect.effects();
    }

    public ModelInstance getInstance() {
        return instance;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    public void setEffect(Effect effect) { this.effect = effect; }

    private Vector3 transformVector(Vector3i in) {
        float x = (3.0f * TILE_SIZE) / 2.0f * (in.x - in.y);
        float y = ((float) Math.sqrt(3.0) * TILE_SIZE) / 2 * (gridSize - in.x - in.y - 1);

        return new Vector3(x, y, 0.0f);
    }

}