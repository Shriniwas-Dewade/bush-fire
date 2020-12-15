package com.kreeda.bushfire;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.scenes.scene2d.*;

public class MyGdxGame implements ApplicationListener
{
	enum Screen {
		Ui,Main,Over,Ad
	}
	
	Screen sc = Screen.Ui;
	Stage stage;
	Player play;
	float w,h;

	@Override
	public void create()
	{
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		stage = new Stage();
		play = new Player();
		play.setTexture("UI/BlueButton.png");
		play.setText("Play");
		play.setSize(50,50);
		play.setPosition(w/2,h/2);
		stage.addActor(play);
	}

	@Override
	public void render()
	{
		if(sc == Screen.Ui){
			Gdx.gl.glClearColor(1, 1, 1, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			stage.act(1/60f);
			stage.draw();
		}
		else if(sc == Screen.Main){
			Gdx.gl.glClearColor(1, 1, 1, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
		}
		else if(sc == Screen.Over){
			Gdx.gl.glClearColor(1, 1, 1, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		}
		
	}

	@Override
	public void dispose()
	{
		stage.dispose();
	}

	@Override
	public void resize(int width, int height)
	{
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}
}
