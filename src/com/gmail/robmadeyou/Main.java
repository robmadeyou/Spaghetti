package com.gmail.robmadeyou;

import java.io.File;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;


public class Main {
	
	private static long lastFrame;

    private static long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

    private static int getDelta() {
        long currentTime = getTime();
        int delta = (int) (currentTime - lastFrame);
        lastFrame = getTime();
        return delta;
    }
	
    public static boolean applet = false;
	public Main(){
		if(!applet){
			try {
				Display.setDisplayMode(new DisplayMode(1020,500));
				Display.setTitle("Particles.. WOO!!");
				Display.create();
				Display.setResizable(false);
			} catch (LWJGLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		glEnable(GL_TEXTURE_2D);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho( 0, 1020, 500, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
	    glEnable(GL_BLEND);
	    glBlendFunc(GL_SRC_ALPHA , GL_ONE_MINUS_SRC_ALPHA);
	    WallList.loadAllLevels();
	    Level.setUpLevel(0);
	    
		while(!Display.isCloseRequested()){
			glClear(GL_COLOR_BUFFER_BIT);
			String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			onUpdate(getDelta(), path);
			Display.sync(60);
			Display.update();
		}
		
	}
	public static void onUpdate(int delta, String path){
		Player.onUpdate();
		WallList.onUpdate();
		SandList.onUpdate(delta);
		Level.onLevelUpdate();
		glColor3f(1,0,0);
		
	    Fonts.drawString("Score: " + path, 0, 50, 1);
	    glColor3f(1,1,1);
	}
	
	public static void main(String args[]){
		new Main();
	}
}
