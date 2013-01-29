package First;

import org.lwjgl.LWJGLException; //import the required classes for SimpleSquareApp

// class name of SimpleSquareApp

public class Main {

// main method where the program starts executing

    public static void main(String arg[]) throws LWJGLException{
    	
    	long start = System.nanoTime();
    	
        long unixTime = System.currentTimeMillis();

        long seconds = unixTime/1000;

        long minutes = seconds / 60;
        
        long hours = minutes / 60;
        
        long days = hours / 24;
        
        long timeTaken = System.nanoTime() - start;
        
        System.out.println(timeTaken);
        System.out.println("Unix time =  " + days + " days");
    }

}

