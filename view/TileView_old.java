package com.pipon.mergeemall.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.utils.Array;
import com.pipon.mergeemall.math.Vector3i;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Gauderic on 09/11/2017.
 * Revision 2 by Quentin on 23/11/2017.
 */

public class TileView_old {
    private ModelInstance instance;
    private final float TILE_SIZE = 25.0f;
    private final float ERROR = 1.0f;

    private int gridSize;
    private float posX, posY;
    private float relativeX, relativeY;
    private Vector3 dir;
    private float speed = 50.0f;
    private boolean isMoving = false;

    public TileView_old(Model model, Array<ModelInstance> instances, float posX, float posY, int gridSize) {
        instance = new ModelInstance(model, posX, 0.0f, posY);
        instance.calculateTransforms();
        instances.add(instance);
        this.posX = posX;   relativeX = posX;
        this.posY = posY;   relativeY = posY;
        this.gridSize = gridSize;
        dir = new Vector3(0.0f,0.0f,0.0f);
    }

    public void setDir(Vector3i dir) {
        posX = relativeX;
        posY = relativeY;
        this.dir = transformVector(dir);
        isMoving = true;
        System.out.println("DIRECTION");
    }

    public void setDir(Vector3 dir) {
        posX = relativeX;
        posY = relativeY;
        this.dir.x = dir.x-posX;
        this.dir.y = dir.y-posY;
        System.out.println("Tile is : "+posX+", "+posY);
        System.out.println("TO : "+dir.x+", "+dir.y);
        System.out.println("-------------------------------");
        isMoving = true;
    }

    public void move() {

        float fromX = relativeX;
        float fromY = relativeY;

        Vector3 tmp = new Vector3(dir.x, dir.y, dir.z);
        Vector3 norDir = tmp.nor();

        float delta = Gdx.graphics.getDeltaTime();

        relativeX += speed * norDir.x * delta;
        relativeY += speed * norDir.y * delta;

        float dx = (posX + dir.x) - relativeX;
        float dy = (posY + dir.y) - relativeY;

        float dd = (float)(Math.sqrt(Math.pow(dx, 2))+ Math.pow(dy, 2));

        instance.transform.translate(relativeX - fromX, 0.0f, relativeY - fromY);

        if(Math.abs(dd) < ERROR) {
            isMoving = false;
            instance.transform.translate(dx, dy, 0.0f);
            posX = posX + dir.x;    relativeX = posX;
            posY = posY + dir.y;    relativeY = posY;
        }

    }

    public void create() {

    }

    public void render() {
        if(isMoving)
            move();
    }

    public void dispose() {

    }

    private Vector3 transformVector(Vector3i in) {
        float x = (3.0f * TILE_SIZE) / 2.0f * (in.x - in.y);
        float y = ((float) Math.sqrt(3.0) * TILE_SIZE) / 2 * (gridSize - in.x - in.y - 1);

        return new Vector3(x, y, 0.0f);
    }
}
