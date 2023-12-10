package ball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BallActor extends Actor {
    private Texture texture;
    private int width;
    private int height;
    private float xSpeed;
    private float ySpeed;

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
}