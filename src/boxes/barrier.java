package boxes;

import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2i;


import static org.lwjgl.opengl.GL11.GL_QUADS;




public class barrier {
	private int x, y, w, h;
	public barrier(int x, int y){
		this.x = x;
		this.y = y;
		this.w = 40;
		this.h = 40;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void draw(){
		
		glBegin(GL_QUADS);
			glVertex2i(x, y);
			glVertex2i(x + w, y);
			glVertex2i(x + w, y + h);
			glVertex2i(x , y + h);
		glEnd();
		
	}
}
