package scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bazai.jackthegiant.GameMain;

public class GamePlay implements Screen {

    private GameMain game;
    private Sprite[] bgs;

    public GamePlay(GameMain game){
        this.game = game;

        createBackgrounds();
    }

    void createBackgrounds(){
        bgs = new Sprite[3];
        for (int i = 0; i < bgs.length; i++) {
            bgs[i] = new Sprite(new Texture("Backgrounds/Game BG.png"));
            bgs[i].setPosition(0,-(i*bgs[i].getHeight()));
        }
    }

    void drawBackgrounds(){
        for (int i = 0; i < bgs.length; i++) {
            game.getBatch().draw(bgs[i],bgs[i].getX(), bgs[i].getY());
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();
        drawBackgrounds();
        game.getBatch().end();
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
