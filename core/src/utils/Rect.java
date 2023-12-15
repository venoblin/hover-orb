package utils;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Rect extends Rectangle {
    private final int width;
    private final int height;
    private final int padding;
    private final Vector2 position;

    public Rect(float x, float y, int width, int height, int padding) {
        this.width = width;
        this.height = height;
        this.padding = padding;
        position = new Vector2(x, y);

        set(x - padding, y - padding, width + (padding * 2), height + (padding * 2));
    }

    public void updatePosition(float x, float y) {
        set(x - padding, y - padding, width + (padding * 2), height + (padding * 2));
    }
}