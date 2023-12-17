package screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.venoblin.hoverorb.HoverOrb;

import actors.BallActor;

public class GameScreen implements Screen {
    private final HoverOrb game;
    private final Stage stage;
    private final BallActor ball;
    private Texture ballTexture;

    public GameScreen(HoverOrb game, Stage stage) {
        this.game = game;
        this.stage = stage;

        ballTexture = new Texture("ball.png");
        ball = new BallActor(ballTexture);

        stage.addActor(ball);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        if (ball.isGameOver()) {
            game.goToMainMenu();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        stage.getRoot().removeActor(ball);
    }

    @Override
    public void dispose() {
        ballTexture.dispose();
        stage.dispose();
        game.dispose();
    }
}