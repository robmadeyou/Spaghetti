package boxes;

import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2i;

public class barrierList {
	static int maxBarriers = 20;
	static barrier[] barr = new barrier[maxBarriers];
	
	public static class bar extends barrier{
		public bar(int x, int y) {
			super(x, y);
		}
	}
	
	public static void addBarrier(bar b){
		for(int i = 0; i < maxBarriers; i++){
			if(barr[i] == null){
				barr[i] = b;
				break;
			}
		}
	}
	public static void draw(){
		for(int i = 0; i < maxBarriers; i++){
			if(barr[i] != null){
				barr[i].draw();
			}
		}
	}
	public static boolean isInBounds(int x, int y){
		for(int i = 0; i< maxBarriers; i++){
			if(barr[i] != null){
				int bX = barr[i].getX();
				int bY = barr[i].getY();
				int bH = 40;
				int bW = 40;
				if(x >= bX && x <= bX + bW && y >= bY && y <= bY + bH){
					return true;
				}
			}
		}
		return false;
	}
}
