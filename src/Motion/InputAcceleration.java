package Motion;

//import the class JOptionPane residing in the package javax.swing
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class InputAcceleration {

 public static void main(String[] args) {

     double g = 0;

     double velocity = 0;
     double position = 0;
     double time = 0;
     double totalTime = 0;
     double dt = 0;
     double lastTime = System.nanoTime()*1E-9;

     int counter = 0;

     // input acceleration
     String accelerationString = JOptionPane.showInputDialog("input acceleration");
     g = Double.parseDouble(accelerationString);

     while(counter < 20000)
     {
        // calculate dt
        time = System.nanoTime()*1E-9;
        dt =  time - lastTime;
        lastTime = time;
       totalTime = totalTime + dt;
       if(g == 2){
    	   System.out.println("DFQWEF");
    	   URL music;
		try {
			music = new URL("http://workbench.cadenhead.org/book/java2412/source/hour15/laugh0.wav");
			AudioClip ve = JApplet.newAudioClip(music);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }

        // calculate the new velocity
        velocity = velocity + g * dt;
        // calculate the new position
        position = position + velocity * dt;

         System.out.println("fallen " + position + "m velocity = " + velocity +  "m/s over " + totalTime);
         counter++;
     }
 }
}

