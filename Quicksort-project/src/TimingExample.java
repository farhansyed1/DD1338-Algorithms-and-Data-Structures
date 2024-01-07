/**
 * An example demonstrating the effects of just-in-time compilation
 * on time measurements.
 *
 * @author Stefan Nilsson
 * @author Farhan Syed
 * @version 2022-03-15
 */
public final class TimingExample {

    /**
     * If you're using a JVM with just-in-time compilation,
     * chanses are that the first reported time is much
     * larger than the rest: during most of the first
     * invocation of the sum() method, the code has yet
     * to be compiled and optimized.
     */
    public static void main(String[] args) {
        final int reps = 5;
        final int extraStartingReps = 5;
        final int n = 1000000;
        final Stopwatch clock = new Stopwatch();

        long sumOfAllTimes = 0;
        long min = 0;
        long max = 0;
        long time = 0;
        for (int i = 0; i < reps + extraStartingReps; i++) {

            clock.reset().start(); {
                long dummy = sum(n);
            }
            time = clock.stop().nanoseconds();
            //Avoids anomalous results
            if(i >= extraStartingReps){
                sumOfAllTimes += time;
                System.out.printf("Time to run sum(%d): %d ns%n", n, time);
                if(max < time){
                    max = time;
                }
                if(min > time || i == extraStartingReps){
                    min = time;
                }
            }


        }
        System.out.println("Average time: " + sumOfAllTimes/reps + " ns");
        System.out.println("Maximum time: " + max + " ns");
        System.out.println("Minimum time: " + min + " ns");

    }

    /**
     * Returns the sum 1 + 2 + ... + n.
     */
    private static long sum(int n) {
       long sum = 0;
       for (int i = 1; i <= n; i++) {
           sum += i;
       }
       return sum;
   }
}
