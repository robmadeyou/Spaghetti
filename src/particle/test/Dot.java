package particle.test;

import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2i;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.GL_POINTS;


public class Dot {
	
	private int x;
	private int y;
	private int dX;
	private int dY;
	float r,g,b,op;
	public Dot(int x, int y){
		this.x = x;
		this.y = y;
		this.dX = 0;
		this.dY = 0;
		
		this.r = 1f;
		this.g = 1f;
		this.b = 1f;
		this.op = 1f;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void setLocation(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	public void onUpdate(int delta){
		
		
		draw();
	}
	
	public void draw(){
		glBegin(GL_POINTS);
			glColor4f(r,g,b,op);
			glVertex2i(x, y);
		glEnd();
	}
}
