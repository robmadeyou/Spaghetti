package com.gmail.robmadeyou;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2i;
import static org.lwjgl.opengl.GL11.GL_LINES;

public class Wall {
	
	
	private int x, y, w, h;
	private String color;
	public Wall(int x, int y,int w,int h, String color){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.color = color;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getWidth(){
		return w;
	}
	public int getHeight(){
		return h;
	}
	public void onUpdate(){
		draw();
	}
	
	public void draw(){
		
		float r = 1,g = 1,b = 1;
		if(color.equals("green")){
			r = 0;
			g = 1;
			b = 0;
		}else if(color.equals("blue")){
			r = 0;
			g = 0;
			b = 1;
		}else if(color.equals("red")){
			r = 1;
			g = 0;
			b = 0;
		}else if(color.equals("cyan")){
			r = 0;
			g = 1;
			b = 1;
		}
		//TODO: Add random quads to the square, haven't decided what amount yet but they
		//should be randomly generated and act as texture
		//to distinguish them I'll probably add opacity to each and every quad then
		//so the color is kept the same, just the shade is turned down (as there will be a dark background)
		glBegin(GL_QUADS);
			glColor4f(r,g,b,1F);
			glVertex2i(x, y);
			glVertex2i(x + w, y);
			glVertex2i(x + w, y + h);
			glVertex2i(x, y + h);
			glColor4f(1,1,1, 1F);
		glEnd();
		
		/* Going to draw a box by just using lines around the wall box, this should give it a FEZ like texture :3
		 * 1.....2
		 * .     .
		 * .     .
		 * 4.....3
		 */
		glColor4f(0,0,0,0.3F);
		//1 to 2
		glBegin(GL_LINES);
			glVertex2i(x, y);
			glVertex2i(x + w, y);
		glEnd();
		
		//2 to 3
		glBegin(GL_LINES);
			glVertex2i(x + w, y);
			glVertex2i(x + w, y + h);
		glEnd();
		
		//3 to 4
		glBegin(GL_LINES);
			glVertex2i(x + w, y + h);
			glVertex2i(x, y + h);
		glEnd();
		
		//4 to 1
		glBegin(GL_LINES);
			glVertex2i(x, y + h);
			glVertex2i(x, y);
		glEnd();
		glColor4f(1,1,1,1F);
		//Done :3
	}
}
