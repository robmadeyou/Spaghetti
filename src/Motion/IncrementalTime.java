package Motion;

public class IncrementalTime {

    public static void main(String[] args) {

        // acceleration due to gravity
        double g = 9.8;

        double velocity = 0;
        double position = 0;
        double time = 0;
        double totalTime = 0;
        double dt = 0;
        double lastTime = System.nanoTime()*1E-9;

        int counter = 0;

        while(counter < 20000)
        {
           // calculate dt
           time = System.nanoTime()*1E-9;
           dt =  time - lastTime;
           lastTime = time;

           totalTime = totalTime + dt;

           // calculate the new velocity
           velocity = velocity + g * dt;
           // calculate the new position
           position = position + velocity * dt;

            System.out.println("fallen " + position + "m velocity = " + velocity +  "m/s over " + totalTime);
            counter++;
        }
    }
}