package com.pipon.mergeemall.input;

import com.badlogic.gdx.InputProcessor;
import com.pipon.mergeemall.grid.Direction;

/**
 * Created by quentin on 2/2/18.
 */

public class InputManager implements InputProcessor {

    private boolean isValid;
    private int lastXLocation, lastYLocation;
    private int dx, dy;

    public InputManager() {
        isValid = false;
    }

    public boolean isValid() {
        return isValid;
    }

    @Override
    public boolean keyDown(int keycode) {
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return true;
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {

        System.out.println("LOCATION : "+x+", "+y);
        lastXLocation = x;
        lastYLocation = y;

        return true;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
        dx = x - lastXLocation;
        dy = y - lastYLocation;

        isValid = true;

        return true;
    }

    @Override
    public boolean touchDragged(int x, int y, int pointer) {
       /* if(lastWasReceived) {
            if(!isValid) {
                dx = x - lastXLocation;
                dy = y - lastYLocation;
            }
            isValid = true;
        } else {
            lastXLocation = x;
            lastYLocation = y;
            lastWasReceived = !lastWasReceived;
        }

       /* float tmpX = (((float)x - (((float) Gdx.graphics.getWidth())/2.0f))/((float)Gdx.graphics.getWidth())) * Game.WIDTH;
        float tmpY = (((float)y - (((float)Gdx.graphics.getHeight())/2.0f))/((float)Gdx.graphics.getHeight())) * Game.HEIGHT;

        //tileView.setDir(new Vector3(tmpX, tmpY, 0));*/

        return true;
    }

    public Direction getDir() {
        if(dx == 0)
            dx += 1;

        int cadran = (dx > 0 && dy < 0) ? 0 : (dx < 0 && dy < 0) ? 2 : (dx < 0 && dy > 0) ? 4 : 6;

        double angle = Math.abs(Math.atan(-((double)dy)/((double)dx)));
        int divider = (angle > (Math.PI/3.0)) ? 1 : 0;
        int discreteAngle = cadran + divider;

        Direction dir = Direction.NORTH;

        switch ((discreteAngle)) {
            case 0 : dir = Direction.NORTH_EAST; break;

            case 1 :
            case 3 : dir = Direction.NORTH; break;

            case 2 : dir = Direction.NORTH_WEST; break;

            case 4 : dir = Direction.SOUTH_WEST; break;

            case 5 :
            case 7 : dir = Direction.SOUTH; break;

            case 6 : dir = Direction.SOUTH_EAST; break;
        }

        isValid = false;

        return dir;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        return true;
    }

}
