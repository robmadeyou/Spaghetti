package boxes;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glVertex2i;

import java.util.Random;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
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
				Display.setTitle("");
				Display.create();
				Display.setResizable(false);
			} catch (LWJGLException e) {
				e.printStackTrace();
			}
		}
		
		glEnable(GL_TEXTURE_2D);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho( 0, 1024, 512, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
	    glEnable(GL_BLEND);
	    glBlendFunc(GL_SRC_ALPHA , GL_ONE_MINUS_SRC_ALPHA);
	    
	    Random random = new Random();
	    boxesList.addNew(new boxesList.boxiis(Mouse.getX(), Display.getHeight() - Mouse.getY()));
	    GreetingServer.Start();
	    while(!Display.isCloseRequested()){
	    	int delta = getDelta();
	    	glClear(GL_COLOR_BUFFER_BIT);
	    	
	    	boxesList.onUpdate(delta);
	    	barrierList.draw();
	    	while(Mouse.next()){
	    		if(Mouse.getEventButtonState()){
	    			if(Mouse.isButtonDown(0)){
	    				
	    				for(int x = 0; x < 50; x++){
	    					int topLeft = 10;
	    					for(int y = 0; y < 50; y++){
	    						
	    							boxesList.addNew(new boxesList.boxiis(
	    									(x - Mouse.getX())^2, 
	    									(y - (Display.getHeight() - Mouse.getY()))^2
	    									
	    									));
	    						
	    						
	    					}
	    				}
	    				
	    			}
	    			
	    		}
	    	}
	    	while(Keyboard.next()){
	    		if(Keyboard.getEventKeyState()){
	    			if(Keyboard.isKeyDown(Keyboard.KEY_C)){
	    				boxesList.clearAll();
	    			}
	    			if(Keyboard.isKeyDown(Keyboard.KEY_X)){
	    				for(int x = 0; x < 50; x++){
	    					boxesList.addNew(new boxesList.boxiis(Mouse.getX() - 25 + x, Display.getHeight() - Mouse.getY() - 25));
	    				}
	    				for(int x = 0; x < 50; x++){
	    					boxesList.addNew(new boxesList.boxiis(Mouse.getX() - 25 + x, Display.getHeight() - Mouse.getY() + 25));
	    				}
	    			}
	    		}
	    	}
	    	if(Mouse.isButtonDown(1)){
				boxesList.RightClickActive = true;
			}
	    	if(Keyboard.isKeyDown(Keyboard.KEY_V)){
	    		boxesList.VKeyActive = true;
	    	}
	    	if(Keyboard.isKeyDown(Keyboard.KEY_B)){
	    		boxesList.BKeyActive = true;
	    	}
	    	if(Keyboard.isKeyDown(Keyboard.KEY_N)){
	    		boxesList.NKeyActive = true;
	    	}
	    	if(Keyboard.isKeyDown(Keyboard.KEY_M)){
	    		boxesList.MKeyActive = true;
	    	}
	    	if(Keyboard.isKeyDown(Keyboard.KEY_L)){
	    		boxesList.LKeyActive = true;
	    	}
	    	Display.update();
	    	Display.sync(60);
	    	
	    }
	    Display.destroy();
	    System.exit(1);
	}
	
	public void onUpdate(){
		
	}
	
	public static void main(String[]args){
		new Main();
	}
}
