package com.venoblin.hoverorb.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.venoblin.hoverorb.input.TouchDetector;

public class BallActor extends Actor {
    private Texture texture;
    private final TouchDetector touchDetector;
    private int width = 300;
    private int height = 300;
    // initial width and height used to reset width and height
    private final int initialWidth = 300;
    private final int initialHeight = 300;
    private final float gravity = 500f;
    private final Vector2 speed = new Vector2(500, 13000);
    private final Vector2 velocity = new Vector2(0, 0);
    private final Vector2 maxVelocity = new Vector2(1000, 100000);
    private boolean isGameOver = false;
    private boolean isGameLive = false;

    public BallActor(Texture texture) {
        this.texture = texture;

        setSize(width, height);
        setToStartPosition();

        touchDetector = new TouchDetector(this, 50);
    }

    private float determineCappedVelocity(float velocity, float maxVelocity) {
        float vel;

        if (velocity < 0) {
            vel = maxVelocity * -1;
        } else {
            vel = maxVelocity;
        }

        return vel;
    }

    private void updatePositionByVelocity(float xVelocity, float yVelocity, float delta) {
        float xVel = xVelocity * delta;
        float yVel = yVelocity * delta;

        if (Math.abs(xVelocity) >= maxVelocity.x) {
            xVel = determineCappedVelocity(xVelocity, maxVelocity.x);
        } else if (Math.abs(yVelocity) >= maxVelocity.y) {
            yVel = determineCappedVelocity(yVelocity, maxVelocity.y);
        }

        setPosition(getX() + xVel, getY() + yVel);
        touchDetector.updateDetectorPosition(getX(), getY());
    }

    public void setToStartPosition() {
        setPosition(
                Gdx.graphics.getWidth() / 2.0f - getWidth() / 2,
                0
        );
    }

    private void resetWidthHeight() {
        width = initialWidth;
        height = initialHeight;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public boolean isGameLive() {
        return isGameLive;
    }

    public boolean isTouched() {
        return touchDetector.isTouched();
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        float leftSide = getX();
        float rightSide = getRight();
        float topSide = getTop();
        float bottomSide = getY();

        velocity.y -= gravity;

        if (bottomSide <= 0) {
            velocity.y = 0;
            velocity.x = 0;

            if (isGameLive) {
                isGameOver = true;
            }
        } else if (topSide >= Gdx.graphics.getHeight()) {
            velocity.y *= -1;
            updatePositionByVelocity(velocity.x, velocity.y, delta);
        } else if (rightSide >= Gdx.graphics.getWidth()) {
            velocity.x *= -1;
            updatePositionByVelocity(velocity.x, velocity.y, delta);
        } else if (leftSide <= 0) {
            velocity.x *= -1;
            updatePositionByVelocity(velocity.x, velocity.y, delta);
        }

        if (touchDetector.isTouched()) {
            if (!isGameLive) {
                isGameLive = true;
            }

            float touchX = touchDetector.getTouchPoints().x;
            float middlePoint = touchDetector.getDetectorMiddlePoint();
            height -= 150;
            velocity.y = speed.y;

            if (touchX < middlePoint - 25) {
                velocity.x = speed.x;
            } else if (touchX > middlePoint + 25) {
                velocity.x = speed.x * - 1;
            }
        } else {
            resetWidthHeight();
        }

        updatePositionByVelocity(velocity.x, velocity.y, delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(texture, getX(), getY(), width, height);
    }
}