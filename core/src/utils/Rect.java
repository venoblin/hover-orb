package utils;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Rect extends Rectangle {
    private final int width;
    private final int height;
    private final Vector2 position;

    public Rect(float x, float y, int width, int height, int padding) {
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);

        set(x, y, width, height);
    }

    public void updatePosition() {
        setPosition(position);
    }
}