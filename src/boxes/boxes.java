package boxes;

import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2i;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.GL_POINTS;
import static org.lwjgl.opengl.GL11.GL_QUADS;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;


public class boxes {
	private int x, y, w, h;
	private int timer;
	private int number;
	private float r,g,b;
	private float opacity;
	private int rotation = 0;
	private int test = 0;
	private boolean diming = false;
	private double dX;
	private double dY;
	private int oX;
	private int oY;
	private boolean stopPls = false;
	private double finaldX;
	private double finaldY;
	private double finaldX2 = 0;
	private double finaldY2 = 0;
	private boolean activated = false;
	public boxes(int x, int y){
		this.x = x;
		this.y = y;
		this.w = 32;
		this.h = 32;
		this.oX = x;
		this.oY = y;
		r = 1;
		g = 1;
		b = 1;
		opacity = 1F;
	}
	public void setNumber(int number){
		this.number = number;
	}
	public int getNumber(){
		return number;
	}
	public void addToOpacity(float amount){
		this.opacity += amount;
	}
	public void setOpacity(float opacity){
		this.opacity = opacity;
	}
	public void activate(){
		activated = true;
	}
	public boolean isActive(){
		return activated;
	}
	public float getOpacity(){
		return opacity;
	}
	public void setD(){
		Random random = new Random();
		int ranDX = 1+random.nextInt(10);
		int ranDY = 1+random.nextInt(10);
		dX = ranDX;
		dY = ranDY;
		
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
	
	public void followDaLeder(int delta){
		if(boxesList.VKeyActive){
			double s = 0.2 * delta;
			double toX = 0;
			double toY = 0;
			if(boxesList.box[number + 1] != null){
				toX = x -(boxesList.box[number + 1].x);
				toY = y - (boxesList.box[number + 1].y);
			}
			double tan = (float) Math.atan2(toX,toY);
		
			double dX = s*Math.sin(tan);
			double dY = s*Math.cos(tan);
			if(!stopPls){
			x -= dX;
			y -= dY;
			finaldX2 = -dX;
			finaldY2 = -dY;
			}
		}else if(boxesList.BKeyActive){
			double s = 0.3 * delta;
			double toX = 0;
			double toY = 0;
			if(number + 2 < boxesList.maxBoxes && boxesList.box[number + 2] != null){
				toX = x -(boxesList.box[number + 2].x);
				toY = y - (boxesList.box[number + 2].y);
			}
			double tan = (float) Math.atan2(toX,toY);
			
			double dX = s*Math.sin(tan);
			double dY = s*Math.cos(tan);
			if(!stopPls){
			x -= dX;
			y -= dY;
			finaldX2 = -dX;
			finaldY2 = -dY;
			}
		}else if(boxesList.NKeyActive){
			double s = 0.3 * delta;
			double toX = 0;
			double toY = 0;
			if(number + 4 < boxesList.maxBoxes && boxesList.box[number + 4] != null){
				toX = x -(boxesList.box[number + 4].x);
				toY = y - (boxesList.box[number + 4].y);
			}
			double tan = (float) Math.atan2(toX,toY);
		
			double dX = s*Math.sin(tan);
			double dY = s*Math.cos(tan);
			if(!stopPls){
			x -= dX;
			y -= dY;
			finaldX2 = -dX;
			finaldY2 = -dY;
			}
		}else if(boxesList.MKeyActive){
			double s = 0.2 * delta;
			double toX = 0;
			double toY = 0;
			Random lul = new Random();
			int ranBox = lul.nextInt(boxesList.numOfBoxes);
			if(boxesList.box[ranBox] != null){
				toX = x -(boxesList.box[ranBox].x);
				toY = y - (boxesList.box[ranBox].y);
			}
			double tan = (float) Math.atan2(toX,toY);
		
			double dX = s*Math.sin(tan);
			double dY = s*Math.cos(tan);
			if(!stopPls){
			x -= dX;
			y -= dY;
			finaldX2 = -dX;
			finaldY2 = -dY;
			}
			if(x >= 1024){
				finaldX = -finaldX;
				setColor("green");
			}
			if(x <= 0){
				finaldX2 = -finaldX2;
				setColor("green");
			}
			if(y >= 512){
				finaldY2 = -finaldY2;
				setColor("green");
			}
			if(y <= 0){
				finaldY2 = -finaldY2;
				setColor("green");
			}
		}else{
			if(!stopPls){
			x += finaldX2;
			y += finaldY2;
			if(finaldX2 > 0){
				finaldX2 -= 0.03;
			}
			if(finaldY2 > 0){
				finaldY2 -= 0.03;
			}
			if(finaldX2 < 0){
				finaldX2 += 0.03;
			}
			if(finaldY2 < 0){
				finaldY2 += 0.03;
			}
			if(x >= 1024){
				finaldX2 = -finaldX2;
				setColor("green");
			}
			if(x <= 0){
				finaldX2 = -finaldX2;
				setColor("green");
			}
			if(y >= 512){
				finaldY2 = -finaldY2;
				setColor("green");
			}
			if(y <= 0){
				finaldY2 = -finaldY2;
				setColor("green");
			}
			}

		}
	}
	public void shake(){
		if(y != oY){
			y = oY;
		}else if(x != oX){
			x = oX;
		}else if(x == oX){
			x += 1;
		}else if(y == oY){
			y += 1;
		}
	}
	public void stop(){
		stopPls = true;
	}
	public void continuepls(){
		stopPls = false;
	}
	public void rightClickDo(int delta){
		double s = 0.6 * delta;
		double toX = 0;
		double toY = 0;
		
		if(number >= 1){
		toX = x -(boxesList.box[number - 1].x);
		toY = y - (boxesList.box[number - 1].y);
		}
		if(boxesList.box[0].number == 0){
			toX = x -(Mouse.getX());
			toY = y - (Display.getHeight() -Mouse.getY());
		}
		double tan = (float) Math.atan2(toX,toY);
		
		double dX = s*Math.sin(tan);
		double dY = s*Math.cos(tan);
		if(!stopPls){
		x -= dX;
		y -= dY;
		}
	}
	public void moveToMousePls(int delta){
		double s = 5;
		
		double toX = 0;
		double toY = 0;
		
		toX = x -(Mouse.getX());
		toY = y - (Display.getHeight() -Mouse.getY());
		
		double tan = (float) Math.atan2(toX,toY);
		
		double dX = s*Math.sin(tan);
		double dY = s*Math.cos(tan);
		
		if(x > Mouse.getX() - 25 && x < Mouse.getX() + 25 && y > Display.getHeight() - Mouse.getY() - 25 && y < Display.getHeight() - Mouse.getY()+ 25){
			if(!stopPls){
			if(barrierList.isInBounds(x, y)){
				dX = -dX;
			}
			x += dX;
			y += dY;
			}
			finaldX = dX;
			finaldY = dY;
			if(x >= 1024){
				finaldX = -finaldX;
				setColor("green");
			}
			if(x <= 0){
				finaldX = -finaldX;
				setColor("green");
			}
			if(y >= 512){
				finaldY = -finaldY;
				setColor("green");
			}
			if(y <= 0){
				finaldY = -finaldY;
				setColor("green");
			}
			
		}else{
			if(x >= 1024){
				finaldX = -finaldX;
				setColor("green");
			}
			if(x <= 0){
				finaldX = -finaldX;
				setColor("green");
			}
			if(y >= 512){
				finaldY = -finaldY;
				setColor("green");
			}
			if(y <= 0){
				finaldY = -finaldY;
				setColor("green");
			}
			
			
			if(!stopPls){
				if(barrierList.isInBounds(x, y)){
					finaldX = -finaldX;
				}
			x += finaldX;
			y += finaldY;
			
			finaldX /= 1.01;
			finaldY /= 1.01;
			}
		}
	}
	public void setRanSize(){
		Random random = new Random();
		int ran = 1+random.nextInt(4);
		w = ran * 16;
		h = w;
	}
	public void setColor(String color){
		if(color.equals("green")){
			r = 0;
			g = 1;
			b = 1;
		}else if(color.equals("blue")){
			r = 0;
			g = 0;
			b = 1;
		}else if(color.equals("red")){
			r = 1;
			g = 0;;
			b = 0;
		}else if(color.equals("white")){
			r = 1;
			g = 1;
			b = 1;
		}
	}
	public void doColor(){
		Random random = new Random();
		int ranColor = 1+random.nextInt(4);
		if(ranColor == 1){
			r = 1;
			g = 1;
			b = 1;
		}else if(ranColor == 2){
			r = 0;
			g = 0;
			b = 1;
		}else if(ranColor == 3){
			r = 0;
			g = 1;
			b = 0;
		}else if(ranColor == 4){
			r = 1;
			g = 0;
			b = 0;
		}
	}
	public void onUpdate(int delta){
	
		if(activated){
			moveToMousePls(delta);
			if(diming){
				addToOpacity(-0.005F);
			}
			if(!diming){
				addToOpacity(0.005F);
			}
			if(opacity >= 1F){
				diming = true;
				opacity = 1F;
			}
			if(opacity <= 0F){
				diming = false;
				test++;
			}
			if(test >= 2){
				activated = false;
				
				test = 0;
			}
		}else{
			
		}
		
	}
	
	public void draw(){
		glBegin(GL_POINTS);
			glColor4f(r,g,b, opacity);
			glVertex2i(x , y);
		glEnd();
	}
}
