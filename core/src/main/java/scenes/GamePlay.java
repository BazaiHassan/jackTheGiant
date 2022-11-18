package scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bazai.jackthegiant.GameMain;

import helper.GameInfo;

public class GamePlay implements Screen {

    private GameMain game;
    private Sprite[] bgs;

    private OrthographicCamera mainCamera;
    private Viewport gameViewport;


    public GamePlay(GameMain game) {
        this.game = game;

        mainCamera = new OrthographicCamera(GameInfo.WIDTH, GameInfo.HEIGHT);
        mainCamera.position.set(GameInfo.WIDTH/2f, GameInfo.HEIGHT / 2f,0);
        gameViewport = new StretchViewport(GameInfo.WIDTH,GameInfo.HEIGHT,mainCamera);
        createBackgrounds();
    }

    void createBackgrounds() {
        bgs = new Sprite[3];
        for (int i = 0; i < bgs.length; i++) {
            bgs[i] = new Sprite(new Texture("Backgrounds/Game BG.png"));
            bgs[i].setPosition(0, -(i * bgs[i].getHeight()));
        }
    }

    void drawBackgrounds() {
        for (int i = 0; i < bgs.length; i++) {
            game.getBatch().draw(bgs[i], bgs[i].getX(), bgs[i].getY());
        }
    }

    void update(float dt){
        moveCamera();
    }

    void moveCamera() {
        mainCamera.position.y -=1;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        update(delta);

        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();
        drawBackgrounds();
        game.getBatch().end();

        game.getBatch().setProjectionMatrix(mainCamera.combined);
        mainCamera.update();
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

    }

    @Override
    public void dispose() {

    }
}
