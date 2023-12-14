package ball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class BallActor extends Actor {
    private Texture texture;
    private int width = 300;
    private int height = 300;
    private final float gravity = -2.0f;
    private float xVelocity;
    private float yVelocity;
    private final float yMaxVelocity = 50f;

    public BallActor(Texture texture) {
        super();
        this.texture = texture;

        setSize(width, height);
        setPosition(
                Gdx.graphics.getWidth() / 2.0f - getWidth() / 2,
                Gdx.graphics.getHeight() / 2.0f - getHeight() / 2
        );

        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                yVelocity += 15f;
                updatePosition(0, yVelocity);
                return true;
            }
        });
    }

    private void updatePosition(float xVelocity, float yVelocity) {
        setPosition(getX() + xVelocity, getY() + yVelocity);
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
            setPosition(getX(), 0);
            yVelocity = 0;
        } else if (topSide >= Gdx.graphics.getHeight()) {
            setPosition(getX(), 0);
        }

        updatePosition(xVelocity, yVelocity);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(texture, getX(), getY(), width, height);
    }

}