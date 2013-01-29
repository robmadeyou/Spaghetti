package Motion;

public class Acceleration {

    public static void main(String[] args) {

        // acceleration due to Earth's gravity
        double g = 9.8;

        double distance = 0;

        double velocity = 0;

        int counter = 0;

        long start = System.nanoTime();

        while(counter < 10000)
        {

           double interval = (System.nanoTime() - start)*1E-9;

           // distance fallen under the influence of gravity
           distance = 0.5 * g * interval * interval;

           // the current velocity
            velocity = g * interval;

           System.out.println("fallen " + distance + "m velocity = " + velocity + "m/s over " + interval +  " seconds");

           counter = counter + 1;
        }
    }
}
