package Lab6;

import java.util.*;

public class Market {

    Random random = new Random(4) ;
    SQueue<Integer> queue = new SQueue<>();
    int mins;
    int total;
    int in;


    public Market(int mins) {
        this.mins = mins;
    }

    public String process() {
        String result = "";
        result += ("min     in      out     total\n");

        int totalMinutes = 0;
        int out = 0;
        for(int currentMinute = 0; currentMinute < mins; currentMinute++) {
            if(queue.dequeue() != null) {
                total--;
                out++;
            }
            int num = random.nextInt(3);

            if(num == 1) {
                in = num;
                queue.enqueue(1);
                total += num;

            }else if(num == 2) {
                in = num;
                queue.enqueue(1);
                queue.enqueue(1);
                total += num;

            }else {
                in = 0;
            }
            totalMinutes += total;
            result += (currentMinute + "\t\t" + in + "\t\t" + out + "\t\t" + total + "\n");
        }
        double avgTime = ((double) totalMinutes / out);
        result += ("\nAverage time in queue: " + avgTime + " minutes\n" );
        return result;
    }
}
