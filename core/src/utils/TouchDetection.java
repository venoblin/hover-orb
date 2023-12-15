package utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class TouchDetection {
    private final Rectangle touchRectangle;

    public TouchDetection(Rectangle touchRectangle) {
        this.touchRectangle = touchRectangle;
    }

    public boolean isTouched() {
        if (Gdx.input.justTouched()) {
            float touchX = Gdx.input.getX();
            float touchY = Gdx.graphics.getHeight() - Gdx.input.getY();

            if (touchRectangle.contains(touchX, touchY)) {
                return true;
            }
        }

        return false;
    }
}