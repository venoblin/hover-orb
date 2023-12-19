package com.venoblin.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class RectTouchDetection {
    private final Rectangle touchRectangle;
    private float touchX;
    private float touchY;

    public RectTouchDetection(Rectangle touchRectangle) {
        this.touchRectangle = touchRectangle;
    }

    public boolean isTouched() {
        if (Gdx.input.justTouched()) {
            touchX = Gdx.input.getX();
            touchY = Gdx.graphics.getHeight() - Gdx.input.getY();

            if (touchRectangle.contains(touchX, touchY)) {
                return true;
            }
        }

        return false;
    }

    public Vector2 getTouchPoints() {
        return new Vector2(touchX, touchY);
    }

}