package huds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bazai.jackthegiant.GameMain;

import helper.GameInfo;
import helper.GameManager;
import scenes.GamePlay;
import scenes.Highscore;
import scenes.Options;

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

        Gdx.input.setInputProcessor(stage);

        createAndPositionBtn();
        addAllListeners();
        stageActor(stage);
        checkMusic();
    }

    private void stageActor(Stage stage) {
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

    } // createAndPositionBtn method

    void addAllListeners(){
        playBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                GameManager.getInstance().gameStartedFromMainMenu = true;
                RunnableAction run = new RunnableAction();
                run.setRunnable(new Runnable() {
                    @Override
                    public void run() {
                        game.setScreen(new GamePlay(game));
                    }
                });

                SequenceAction sa = new SequenceAction();
                sa.addAction(Actions.fadeOut(1f));
                sa.addAction(run);

                stage.addAction(sa);
            }
        });

        highScoreBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new Highscore(game));
            }
        });

        optionsBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new Options(game));
            }
        });

        quitBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        musicBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (GameManager.getInstance().gameData.isMusicOn()){
                    GameManager.getInstance().gameData.setMusicOn(false);
                    GameManager.getInstance().stopMusic();
                }else {
                    GameManager.getInstance().gameData.setMusicOn(true);
                    GameManager.getInstance().playMusic();
                }

                GameManager.getInstance().saveData();
            }
        });
    } // addAllListeners method

    void checkMusic(){
        if (GameManager.getInstance().gameData.isMusicOn()){
            GameManager.getInstance().playMusic();
        }
    }

    public Stage getStage() {
        return stage;
    }
} //MainMenuButtons
