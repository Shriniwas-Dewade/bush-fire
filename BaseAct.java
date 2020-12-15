package com.kreeda.bushfire;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.scenes.scene2d.*;

public class BaseAct extends Actor
{
	Texture tex;
	TextureRegion r;
	TextureRegion[] tmp;
	Animation anime;
	Rectangle rec;
	BitmapFont font;
	String tm;
	boolean a,b,c;
	float time;
	
	public BaseAct(){
		r = new TextureRegion();
		rec = new Rectangle();
		anime = null;
		a = false;
		b = false;
	}
	public void setTexture(String t){
		tex = new Texture(t);
		r.setRegion(tex);
		b = true;
	}

	public void setAnimation(String[] s,float time,boolean b){
		int l = s.length;
		tmp = new TextureRegion[l];
		for(int i = 0;i < l;i++){
			tex = new Texture(s[i]);
			r.setRegion(tex);
			tmp[i] = r;
		}
		anime = new Animation(time,tmp);
	}
	
	public void setText(String f){
		a = true;
		font = new BitmapFont();
		tm = f;
	}
	
	public Rectangle getRectangle()
	{
		rec.setPosition( getX(), getY() );
		return rec;
	}
	
	public boolean overlaps(BaseAct other)
	{
		return this.getRectangle().overlaps( other.getRectangle() );
	}
	
	public void act(float dt)
	{
		super.act(dt);
		time += dt;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		super.draw(batch, parentAlpha);
		
		if(isVisible() && anime != null){
			batch.draw(anime.getKeyFrame(time,true),getX(),getY(),getWidth(),getHeight());
		}else if(a && isVisible()){
			font.draw(batch,tm,1,1);
		}else if(b && isVisible()){
			batch.draw(r,getX(),getY(),getWidth(),getHeight());
		} 
	}
}
