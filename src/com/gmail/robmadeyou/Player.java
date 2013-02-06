package com.gmail.robmadeyou;

import static org.lwjgl.opengl.GL11.GL_QUADS;

import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glVertex2i;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glPopMatrix;

public class Player {
	
	private int x, y, rotation;
	public Player(int x, int y, int rotation){
		this.x = x;
		this.y = y;
		this.rotation = rotation;
	}
	
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void setRotation(int rotation){
		this.rotation = rotation;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getRotation(){
		return rotation;
	}
	
	
	
	public void draw(){
		glBegin(GL_QUADS);
			glVertex2i(x, y);  
			glVertex2i(x + 30, y);
			glVertex2i(x + 30, y + 30);
			glVertex2i(x, y + 30);
		glEnd();
		
		glPopMatrix();
	}
}
