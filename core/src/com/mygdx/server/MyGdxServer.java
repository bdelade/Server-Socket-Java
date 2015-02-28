package com.mygdx.server;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MyGdxServer extends ApplicationAdapter  implements Runnable {

static boolean title=false;
private  FlowManager fManager=null ;
private CircleDrawer cDrawer;

	
private ArrayList<Circle> Clist=new ArrayList<Circle>();

	
	
	@Override
	public void create () {
		cDrawer=new  CircleDrawer();
		//fManager= new FlowManager();
		
		Gdx.input.setInputProcessor(new InputAdapter () {
			public boolean touchDown (int x, int y, int pointer, int button) {
				if ((button == Input.Buttons.LEFT) && (fManager.erreur())	&& title ) {
					
					
					Circle cercle = new Circle((float) Gdx.input.getX(), (float) Gdx.graphics.getHeight() - Gdx.input.getY());
					fManager.sendCircle(cercle);
					
					
				}
				return true;
			}
	
		});
		(new Thread(this)).start();
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		 
		if(  fManager!=null){
			initTitle();
		}
		cDrawer.beginDraw();
		for (Circle cercle : Clist) cDrawer.drawCircle(cercle);
		cDrawer.endDraw();
		
		
		
	}

	public void initTitle(){
		
		
		if(fManager.isserv()){Gdx.graphics.setTitle("Server");}
		else Gdx.graphics.setTitle("Client");
		title=true;
		
		
	}
	
	
	

	public void run() {
		// On établit le réseau dès que possible mais sans bloquer le rendu
		
		
		if (fManager==null){ fManager = new FlowManager();
 
		System.out.println("ini");
		}

		Circle cercle;
		
	 
	
		while(true) if((cercle = fManager.circleReceiver()) != null) Clist.add(cercle);
		
		
		
	}
	
	
}
