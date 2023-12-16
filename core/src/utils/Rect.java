package utils;

import com.badlogic.gdx.math.Rectangle;

public class Rect extends Rectangle {
    private final int width;
    private final int height;
    private final int padding;

    public Rect(float x, float y, int width, int height, int padding) {
        this.width = width;
        this.height = height;
        this.padding = padding;

        set(x - padding, y - padding, width + (padding * 2), height + (padding * 2));
    }

    public void updatePosition(float x, float y) {
        setPosition(x - padding, y - padding);
    }

    public float getMiddlePoint() {
        return getX() + getWidth() / 2;
    }
}