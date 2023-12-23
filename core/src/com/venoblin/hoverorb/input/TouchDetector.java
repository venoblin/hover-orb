package com.venoblin.hoverorb.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class TouchDetector {
    private final Rectangle touchRectangle;
    private float touchX;
    private float touchY;
    private final float padding;

    public TouchDetector(Actor targetActor, float padding) {
        this.padding = padding;
        this.touchRectangle = new Rectangle(
                targetActor.getX() - padding,
                targetActor.getY() - padding,
                targetActor.getWidth() + (padding * 2),
                targetActor.getHeight() + (padding * 2)
        );
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

    public void updateDetectorPosition(float x, float y) {
        touchRectangle.setPosition(x - padding, y - padding);
    }

    public float getDetectorMiddlePoint() {
        return touchRectangle.getX() + touchRectangle.getWidth() / 2;
    }
}