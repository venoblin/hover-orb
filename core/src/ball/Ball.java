package ball;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Ball extends Actor {
    private Texture texture;

    Ball(Texture texture) {
        this.texture = texture;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}