package ball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BallActor extends Actor {
    private Texture texture;
    private int width = 300;
    private int height = 300;
    private float gravity = 2.0f;
    private float leftSide;
    private float rightSide;
    private float topSide;
    private float bottomSide;

    public BallActor(Texture texture) {
        this.texture = texture;

        setSize(this.width, this.height);
        setPosition(
                Gdx.graphics.getWidth() / 2.0f - getWidth() / 2,
                Gdx.graphics.getHeight() / 2.0f - getHeight() / 2
        );
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        this.leftSide = getX();
        this.rightSide = getRight();
        this.topSide = getTop();
        this.bottomSide = getY();
        setPosition(getX(), getY() - gravity);

        if (bottomSide <= 0) {
            setPosition(getX(), 0);
        }

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(texture, getX(), getY(), this.width, this.height);
    }
}