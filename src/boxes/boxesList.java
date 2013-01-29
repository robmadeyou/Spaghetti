package boxes;

import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2i;

import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class boxesList {
	static int maxBoxes = 131072;
	static boxes box[] = new boxes[maxBoxes];
	static int numOfBoxes = -1;
	
	
	public static class boxiis extends boxes{
		public boxiis(int x, int y) {
			super(x, y);
		}
	}
	public static void clearAll(){
		for(int i = 1; i< maxBoxes - 1; i++){
			box[i] = null;
		}
	}
	public static void addNew(boxiis b){
		numOfBoxes++;
		for(int i = 0; i < maxBoxes; i++){
			if(box[i] == null){
				box[i] = b;
				box[i].setNumber(i);
				box[i].activate();
				break;
			}
		}
	}
	static boolean RightClickActive = false;
	static boolean VKeyActive = false;
	static boolean BKeyActive = false;
	static boolean NKeyActive = false;
	static boolean MKeyActive = false;
	static boolean LKeyActive = false;
	public static void onUpdate(int delta){
		box[0].activate();
		box[0].setColor("green");
		for(int i = 0; i < maxBoxes; i++){
			if(box[i] != null){
				if(LKeyActive){
					if(box[i + 1] != null){
						glBegin(GL_LINES);
							glVertex2i(box[i].getX(), box[i].getY());
							glVertex2i(box[i + 1].getX(), box[i + 1].getY());
						glEnd();
					}
				}
				if(RightClickActive){
					box[i].rightClickDo(delta);
				}else{
				box[i].followDaLeder(delta);
				Random randomz = new Random();
				int turnOnPls = randomz.nextInt(100);
				if(turnOnPls == 1){
					box[i].activate();
				}
				int gogogo = randomz.nextInt(10000);
				if(gogogo == 5){
					box[i].setColor("red");
				}
				
				if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
					box[i].stop();
				}else{
					box[i].continuepls();
				}
				box[i].onUpdate(delta);
				}
				if(box[numOfBoxes] != null){
				box[numOfBoxes].setX(Mouse.getX());
				box[numOfBoxes].setY(Display.getHeight() - Mouse.getY());
				}
				box[i].draw();
			}
		}
		RightClickActive = false;
		VKeyActive = false;
		BKeyActive = false;
		NKeyActive = false;
		MKeyActive = false;
		LKeyActive = false;
	}
}
