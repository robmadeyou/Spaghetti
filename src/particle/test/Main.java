package particle.test;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glClear;

import java.util.Random;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

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
	
	static boolean applet = false;
	
	public Main(){
		if(!applet){
			try {
				Display.setDisplayMode(new DisplayMode(1024,512));
				Display.setTitle("Particles.. WOO!!");
				Display.create();
				Display.setResizable(false);
				
			} catch (LWJGLException e) {
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
		    
		    
		    int dotsOnScreen = 600;
		    while(!Display.isCloseRequested()){
		    	glClear(GL_COLOR_BUFFER_BIT);
		    	
		    	onUpdate(getDelta());
		    	Random ran = new Random();
		    	int ranX = ran.nextInt(1024);
		    	int ranY = ran.nextInt(512);
		    	if(dotsOnScreen >= 1){
		    		DotList.addDot(new DotList.dots(ranX, ranY));
		    		dotsOnScreen--;
		    	}
		    	System.out.println("I am spawning shit!");
		    	Display.sync(60);
		    	Display.update();
		    	
		    }
		}
	}
	
	public static void onUpdate(int delta){
		DotList.onUpdate(delta);
	}
	
	public static void main(String []args){
		new Main();
	}
}
