package com.gmail.robmadeyou;


import static org.lwjgl.opengl.GL11.GL_POINTS;

import java.text.DecimalFormat;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2i;
import static org.lwjgl.opengl.GL11.glColor3f;


public class Sand {
	
	private int x, y;
	private double dX, dY;
	private boolean isMovingToMouse;
	private String color;
	private boolean isInFinish;
	public Sand(int x, int y, String color){
		this.x = x;
		this.y = y;
		this.color = color;
		this.dX = 0;
		this.dY = 0;
		this.isMovingToMouse = false;
		this.isInFinish = false;
	}
	public void setToFinish(boolean set){
		this.isInFinish = set;
	}
	public boolean isInFinish(){
		return isInFinish;
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
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void addX(int x){
		this.x = this.x + x;
	}
	public void addY(int y){
		this.y = this.y + y;
	}
	public void setVel(double dX, double dY){
		this.dX = dX;
		this.dY = dY;
	}
	public void setMovingToMouse(boolean bool){
		this.isMovingToMouse = bool;
	}
	public void draw(){
		
		float r = 1,g = 1,b = 1;
		if(color.equals("green")){
			r = 0;
			g = 0;
			b = 1;
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
		
		glBegin(GL_POINTS);
			glColor3f(r,g,b);
			glVertex2i(x, y);
		glEnd();
			
	}
	public void onUpdate(){
		draw();
		if(!isInFinish){
			if(isMovingToMouse){
				double s = 3;
			
				double toX = 0;
				double toY = 0;
			
				toX = x -(Mouse.getX());
				toY = y - (Display.getHeight() -Mouse.getY());
			
				double tan = (float) Math.atan2(toX,toY);
			
				dX = -s*Math.sin(tan);
				dY = -s*Math.cos(tan);
			
				x += dX;
				y += dY;
			}else{
				x += dX;
				y += dY;
			
				if(dX > 0){
					dX -= 0.06;
				}
				if(dY > 0){
					dY -= 0.06;
				}
				if(dX < 0){
					dX += 0.06;
				}
				if(dY < 0){
					dY += 0.06;
				}
		
			}
		}else{
			x += dX;
			y += dY;
		
			if(dX > 0){
				dX -= 0.06;
			}
			if(dY > 0){
				dY -= 0.06;
			}
			if(dX < 0){
				dX += 0.06;
			}
			if(dY < 0){
				dY += 0.06;
			}
	
		}
	}
}
