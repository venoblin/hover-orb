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
    private float gravity = -2.0f;
    private float xSpeed;
    private float ySpeed;



    public BallActor(Texture texture) {
        super();
        this.texture = texture;

        setSize(this.width, this.height);
        setPosition(
                Gdx.graphics.getWidth() / 2.0f - getWidth() / 2,
                Gdx.graphics.getHeight() / 2.0f - getHeight() / 2
        );

        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Actor touched!");

                return true;
            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        float leftSide = getX();
        float rightSide = getRight();
        float topSide = getTop();
        float bottomSide = getY();
        this.ySpeed += gravity;

        setPosition(getX() + this.xSpeed, getY() + this.ySpeed);

        if (bottomSide <= 0) {
            setPosition(getX(), 0);
        } else if (topSide >= Gdx.graphics.getHeight()) {
            setPosition(getX(), 0);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(texture, getX(), getY(), this.width, this.height);
    }

}