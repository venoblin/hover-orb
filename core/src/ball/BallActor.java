package ball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BallActor extends Actor {
    private Texture texture;
    private int width = 250;
    private int height = 250;

    public BallActor(Texture texture) {
        this.texture = texture;
        setSize(this.width, this.height);
        setPosition(
                Gdx.graphics.getWidth() / 2.0f,
                Gdx.graphics.getHeight() / 2.0f);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(texture, getX(), getY(), this.width, this.height);
    }
}