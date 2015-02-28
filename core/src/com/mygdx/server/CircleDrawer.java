package com.mygdx.server;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.graphics.Color;
 
public class CircleDrawer {
	
	private ShapeRenderer shaperend;
	private Color couleur;
		
	
	public CircleDrawer(){
		shaperend= new ShapeRenderer();
		couleur=Color.BLACK;	
		shaperend.setColor(couleur);
		
	}
	
	public void beginDraw(){
		shaperend.begin(ShapeType.Filled);
		
		
	}
	
	
	public void drawCircle(Circle cercle) {
		
		shaperend.ellipse(cercle.getX() - cercle.getDiam()/2, cercle.getY() - cercle.getDiam()/2,
				cercle.getDiam(), (int) cercle.getDiam());
	}
	
	public void endDraw() {
		shaperend.end();
	}
	
	
	
	

}
