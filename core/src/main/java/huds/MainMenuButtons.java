package huds;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bazai.jackthegiant.GameMain;

import helper.GameInfo;

public class MainMenuButtons {

    private GameMain game;
    private Stage stage;
    private Viewport gameViewport;
    private ImageButton playBtn, highScoreBtn, optionsBtn, quitBtn, musicBtn;

    public MainMenuButtons(GameMain game) {
        this.game = game;
        gameViewport = new FitViewport(
                GameInfo.WIDTH,
                GameInfo.HEIGHT,
                new OrthographicCamera()
        );

        stage = new Stage(gameViewport, game.getBatch());
        createAndPositionBtn();
        stage.addActor(playBtn);
        stage.addActor(highScoreBtn);
        stage.addActor(optionsBtn);
        stage.addActor(quitBtn);
        stage.addActor(musicBtn);
    }

    void createAndPositionBtn() {
        playBtn = new ImageButton(
                new SpriteDrawable(
                        new Sprite(
                                new Texture("Buttons/MainMenu/Start Game.png")
                        )
                )
        );

        highScoreBtn = new ImageButton(
                new SpriteDrawable(
                        new Sprite(
                                new Texture("Buttons/MainMenu/Highscore.png")
                        )
                )
        );

        optionsBtn = new ImageButton(
                new SpriteDrawable(
                        new Sprite(
                                new Texture("Buttons/MainMenu/Options.png")
                        )
                )
        );

        quitBtn = new ImageButton(
                new SpriteDrawable(
                        new Sprite(
                                new Texture("Buttons/MainMenu/Quit.png")
                        )
                )
        );

        musicBtn = new ImageButton(
                new SpriteDrawable(
                        new Sprite(
                                new Texture("Buttons/MainMenu/Music On.png")
                        )
                )
        );

        // Set Position of all buttons
        playBtn.setPosition(GameInfo.WIDTH / 2f - 80, GameInfo.HEIGHT / 2f + 50, Align.center);
        highScoreBtn.setPosition(GameInfo.WIDTH / 2f - 60, GameInfo.HEIGHT / 2f - 20, Align.center);
        optionsBtn.setPosition(GameInfo.WIDTH / 2f - 40, GameInfo.HEIGHT / 2f - 90, Align.center);
        quitBtn.setPosition(GameInfo.WIDTH / 2f - 20, GameInfo.HEIGHT / 2f - 160, Align.center);
        musicBtn.setPosition(GameInfo.WIDTH  - 13, 13, Align.bottomRight);


    }

    public Stage getStage() {
        return stage;
    }
} //MainMenuButtons
