package com.gmail.robmadeyou;

import java.util.ArrayList;

public class WallList {
	public static class Walls extends Wall{
		public Walls(int x, int y, int w, int h, String color) {
			super(x, y, w, h, color);
		}
	}
	
	static Wall[][] wall = new Wall[10][100];
	//Loads all the levels in their proper arrays; just for now. Does not do anything with them
	//until the actual level is run, where then only they are being drawn, and the collision is
	//being calculated
	public static void loadAllLevels(){
		/*
		 * 
		 * Please future me follow this order:
		 * [0] = START POSITION;
		 * [1] = END POSITION;
		 * [2+] = WALL BLOCKS;
		 * 
		 * 
		 * THANKYOU!c
		 */
		
		wall[0][2] = new Walls(40, 40, 70, 60, "green");
		wall[0][3] = new Walls(100, 69, 70, 60, "red");
	}
	public static void onUpdate(){
		for(int i = 0; i < 100; i++){
			if(wall[Level.currentLevel][i] != null){
				wall[Level.currentLevel][i].onUpdate();
			}
		}
	}
}
