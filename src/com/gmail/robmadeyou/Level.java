package com.gmail.robmadeyou;

public class Level {
	/*
	 * Current level decides which level to draw right now and
	 * it also decides which level will the collision be tested on. This plays
	 * a very large role in the game and is very vital
	 */
	public static int currentLevel = 0;
	/*
	 * This will be used for other difficulties
	 * On harder levels the number of sand grains will not 
	 * reset upon new level; instead it will be globally kept a record of
	 */
	public static int dotsOnScreen = 20;
	/*
	 * Score is kept globally and will increase as the player progresses on with the game
	 */
	public static int score = 0;
}
