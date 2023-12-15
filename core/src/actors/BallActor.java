package actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import utils.Rect;
import utils.RectTouchDetection;

public class BallActor extends Actor {
    private Texture texture;
    private Rect touchRect;
    private RectTouchDetection touchBounds;
    private int width = 300;
    private int height = 300;
    // initial width and height used to reset width and height
    private final int initialWidth = 300;
    private final int initialHeight = 300;
    private final float gravity = -10.0f;
    private final Vector2 velocity = new Vector2(0, 0);
    private final Vector2 maxVelocity = new Vector2(10, 150);

    public BallActor(Texture texture) {
        this.texture = texture;

        setSize(width, height);
        setToStartPosition();

        touchRect = new Rect(getX(), getY(), width, height, 50);
        touchBounds = new RectTouchDetection(touchRect);
    }

    private void updatePositionByVelocity(float xVelocity, float yVelocity) {
        setPosition(getX() + xVelocity, getY() + yVelocity);
        touchRect.updatePosition(getX(), getY());
    }

    private void setToStartPosition() {
        setPosition(
                Gdx.graphics.getWidth() / 2.0f - getWidth() / 2,
                0
        );
    }

    private void resetWidthHeight() {
        width = initialWidth;
        height = initialHeight;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        float leftSide = getX();
        float rightSide = getRight();
        float topSide = getTop();
        float bottomSide = getY();

        velocity.y += gravity;
        if (velocity.y >= maxVelocity.y) {
            velocity.y = maxVelocity.y;
        } else if (velocity.x >= maxVelocity.x) {
            velocity.x = maxVelocity.x;
        }

        if (bottomSide <= 0) {
//            setToStartPosition();
            setPosition(getX(), 0);
            velocity.y = 0;
            velocity.x = 0;
        } else if (topSide >= Gdx.graphics.getHeight()) {
            velocity.y *= -1;
            updatePositionByVelocity(velocity.x, velocity.y);
        } else if (rightSide >= Gdx.graphics.getWidth()) {
            velocity.x *= -1;
            updatePositionByVelocity(velocity.x, velocity.y);
        } else if (leftSide <= 0) {
            velocity.x *= -1;
            updatePositionByVelocity(velocity.x, velocity.y);
        }

        if (touchBounds.isTouched()) {
            float touchX = touchBounds.getTouchPoints().x;
            velocity.y += 700f;
            velocity.x -= 5f;

            if (getX() < touchX && touchX < getX() + getWidth() / 2) {
                height -= 150;
            }
        } else {
            resetWidthHeight();
        }

        updatePositionByVelocity(velocity.x, velocity.y);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(texture, getX(), getY(), width, height);
    }
}