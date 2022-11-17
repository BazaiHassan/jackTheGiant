package com.bazai.jackthegiant;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import scenes.GamePlay;

public class GameMain extends Game {
	private SpriteBatch batch;

	@Override
	public void create() {
		batch = new SpriteBatch();
		setScreen(new GamePlay(this));
	}

	@Override
	public void render() {
		super.render();
	}

	public SpriteBatch getBatch(){
		return this.batch;
	}


}