import java.util.Random;

/**
 * A quicksort algorithm that uses a random pivot and an insertion sort for small arrays.
 *
 * @author Farhan Syed
 * @version 2022-03-01
 */
public class QuicksortRandomPivotInsertion extends Quicksort implements IntSorter{

    Random random = new Random();

    /**
     * Sorts the array using quicksort.
     *
     * @param v An array of ints.
     */
    @Override
    public void sort(int[] v) {
        quickSort(v,0,v.length-1);
    }

    private void quickSort(int[] array, int low, int high) {
        if(low < high){
            if(high-low > 100){
                //pivot is randomly chosen
                int pivot = low + random.nextInt((high-low));
                swap(pivot, high, array);
                pivot = array[high];

                //partitioning
                pivot = partition(array, low, high, pivot);
                quickSort(array, low, pivot - 1);
                quickSort(array, pivot + 1, high);
            }
            else {
                iSort(array,low,high+1);
            }
        }

    }

}
