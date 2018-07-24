package com.pipon.mergeemall;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.pipon.mergeemall.input.InputManager;
import com.pipon.mergeemall.view.GameScene;

public class Game extends ApplicationAdapter {
	public static final String TITLE = "MERGE'EM ALL";
	public static final int WIDTH = 600;
	public static final int HEIGHT = 400;

	private GameScene gs = new GameScene();
	private InputManager inputManager = new InputManager();

	@Override
	public void create () {
		gs.create();
		gs.render();
		Gdx.input.setInputProcessor(inputManager);
	}

	@Override
	public void render () {
		if(inputManager.isValid()) {
			System.out.println(inputManager.getDir());
			gs.render();
		}
	}

	@Override
	public void dispose () {
		gs.dispose();
	}
}