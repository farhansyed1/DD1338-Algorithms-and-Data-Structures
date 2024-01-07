import java.util.Arrays;

/**
 *  Class used to measure the running time for different sorting algorithms.
 *
 *  @author Farhan Syed
 *  @version 2022-03-15
 */
public class TimingSortingAlgorithms {

    public static void main(String[] args) {
        //Example of how the testing was conducted
        int size = 1000;
        Data data = new Data(size, size, Data.Order.RANDOM);
        QuicksortFixedPivot fixedPivot = new QuicksortFixedPivot();

        calculateTime(fixedPivot, data);
    }

    private static void calculateTime(IntSorter sortingAlgorithm, Data data) {
        final int reps = 500;
        final int extraStartingReps = 50;
        final Stopwatch clock = new Stopwatch();

        long sumOfAllTimes = 0;
        long time = 0;
        for (int i = 0; i < reps + extraStartingReps; i++) {

            clock.reset().start(); {
                sortingAlgorithm.sort(data.get());
            }
            time = clock.stop().nanoseconds();
            //To avoid anomalous results
            if (i >= extraStartingReps) {
                sumOfAllTimes += time;
            }
        }
        System.out.println("Average time: " + sumOfAllTimes/reps + " ns");
    }

    private static void arraySort(Data data) {
        final int reps = 500;
        final int extraStartingReps = 50;
        final Stopwatch clock = new Stopwatch();

        long sumOfAllTimes = 0;
        long time = 0;
        for (int i = 0; i < reps + extraStartingReps; i++) {

            clock.reset().start(); {
                Arrays.sort(data.get());
            }
            time = clock.stop().nanoseconds();
            //To avoid anomalous results
            if (i >= extraStartingReps) {
                sumOfAllTimes += time;
            }
        }
        System.out.println("Average time: " + sumOfAllTimes/reps + " ns");
    }

}
