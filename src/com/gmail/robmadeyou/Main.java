package com.gmail.robmadeyou;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;


public class Main {
	
	public static class Playor extends Player{
		public Playor(int x, int y, int rotation) {
			super(x, y, rotation);
		}
	}
	
	public Main(){
	
		try {
			Display.setDisplayMode(new DisplayMode(1024,512));
			Display.setTitle("Particles.. WOO!!");
			Display.create();
			Display.setResizable(false);
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		glEnable(GL_TEXTURE_2D);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho( 0, 1024, 512, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
	    glEnable(GL_BLEND);
	    glBlendFunc(GL_SRC_ALPHA , GL_ONE_MINUS_SRC_ALPHA);
		
	    Playor newP = new Playor(200, 200, 0);
	    
		while(!Display.isCloseRequested()){
			glClear(GL_COLOR_BUFFER_BIT);
			
			newP.draw();
			Display.sync(60);
			Display.update();
		}
		
	}
	
	
	public static void main(String args[]){
		new Main();
	}
}
