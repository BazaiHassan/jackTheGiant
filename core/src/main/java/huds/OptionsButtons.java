package huds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bazai.jackthegiant.GameMain;

import helper.GameInfo;
import helper.GameManager;
import scenes.MainMenu;

public class OptionsButtons {

    private GameMain game;
    private Viewport gameViewport;
    private Stage stage;

    private ImageButton easy, medium, hard, backBtn;
    private Image sign;

    public OptionsButtons(GameMain game) {
        this.game = game;

        gameViewport = new FitViewport(GameInfo.WIDTH, GameInfo.HEIGHT, new OrthographicCamera());

        stage = new Stage(gameViewport, game.getBatch());

        Gdx.input.setInputProcessor(stage);
        createAndPositionButtons();
        addListeners();
        stageActor(stage);
    }

    private void stageActor(Stage stage) {
        stage.addActor(easy);
        stage.addActor(medium);
        stage.addActor(hard);
        stage.addActor(sign);
        stage.addActor(backBtn);
    }

    void createAndPositionButtons() {
        easy = new ImageButton(new SpriteDrawable(new Sprite(new Texture("Buttons/OptionsMenu/Easy.png"))));
        medium = new ImageButton(new SpriteDrawable(new Sprite(new Texture("Buttons/OptionsMenu/Medium.png"))));
        hard = new ImageButton(new SpriteDrawable(new Sprite(new Texture("Buttons/OptionsMenu/Hard.png"))));
        backBtn = new ImageButton(new SpriteDrawable(new Sprite(new Texture("Buttons/OptionsMenu/Back.png"))));
        sign = new Image(new SpriteDrawable(new Sprite(new Texture("Buttons/OptionsMenu/Check Sign.png"))));


        // positions
        backBtn.setPosition(17, 17, Align.bottomLeft);
        easy.setPosition(GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2f + 40, Align.center);
        medium.setPosition(GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2f - 40, Align.center);
        hard.setPosition(GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2f - 120, Align.center);

        positionTheSign();
    }

    void addListeners() {
        backBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MainMenu(game));
            }
        });

        easy.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                changeDifficulty(0);
                sign.setY(easy.getY() + 13);
            }
        });

        medium.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                changeDifficulty(1);
                sign.setY(medium.getY() + 13);
            }
        });

        hard.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                changeDifficulty(2);
                sign.setY(hard.getY() + 13);
            }
        });
    }

    void positionTheSign() {
        if (GameManager.getInstance().gameData.isEasyDifficulty()) {
            sign.setPosition(easy.getX() + easy.getWidth() - 50, easy.getY() + 13, Align.bottomLeft);
        }

        if (GameManager.getInstance().gameData.isMediumDifficulty()) {
            sign.setPosition(medium.getX() + medium.getWidth() - 50, medium.getY() + 13, Align.bottomLeft);
        }

        if (GameManager.getInstance().gameData.isHardDifficulty()) {
            sign.setPosition(hard.getX() + hard.getWidth() - 50, hard.getY() + 13, Align.bottomLeft);
        }
    }

    void changeDifficulty(int difficulty){

        switch (difficulty){
            case 0:
                GameManager.getInstance().gameData.setEasyDifficulty(true);
                GameManager.getInstance().gameData.setMediumDifficulty(false);
                GameManager.getInstance().gameData.setHardDifficulty(false);
                break;
            case 1:
                GameManager.getInstance().gameData.setEasyDifficulty(false);
                GameManager.getInstance().gameData.setMediumDifficulty(true);
                GameManager.getInstance().gameData.setHardDifficulty(false);
                break;
            case 2:
                GameManager.getInstance().gameData.setEasyDifficulty(false);
                GameManager.getInstance().gameData.setMediumDifficulty(false);
                GameManager.getInstance().gameData.setHardDifficulty(true);
                break;
        }

        GameManager.getInstance().saveData();

    }

    public Stage getStage() {
        return stage;
    }
} // OptionsButtons
