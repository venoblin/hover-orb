package ball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BallActor extends Actor {
    private Texture texture;
    private Rectangle touchBounds;
    private int width = 300;
    private int height = 300;
    // initial width and height used to reset width and height
    private final int initialWidth = 300;
    private final int initialHeight = 300;
    private final float gravity = -10.0f;
    private float xVelocity;
    private float yVelocity;
    private final float yMaxVelocity = 150f;

    public BallActor(Texture texture) {
        super();
        this.texture = texture;

        setSize(width, height);
        startingPosition();

        touchBounds = new Rectangle(getX() - 50, getY() - 50, width + 100, height + 100);
    }

    private  void updateTouchBounds() {
        touchBounds.set(getX() - 50, getY() - 50, width + 100, height + 100);
    }

    private void updatePositionByVelocity(float xVelocity, float yVelocity) {
        setPosition(getX() + xVelocity, getY() + yVelocity);
        updateTouchBounds();
    }

    private void startingPosition() {
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

        yVelocity += gravity;
        if (yVelocity >= yMaxVelocity) {
            yVelocity = yMaxVelocity;
        }

        if (bottomSide <= 0) {
            startingPosition();
            yVelocity = 0;
        } else if (topSide >= Gdx.graphics.getHeight()) {
            yVelocity *= -1;
            updatePositionByVelocity(xVelocity, yVelocity);
        }

        if (Gdx.input.justTouched()) {
            float touchX = Gdx.input.getX();
            float touchY = Gdx.graphics.getHeight() - Gdx.input.getY();

            if (touchBounds.contains(touchX, touchY)) {
//                yVelocity += 700f;

            }
        }

        updatePositionByVelocity(xVelocity, yVelocity);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(texture, getX(), getY(), width, height);
    }

}