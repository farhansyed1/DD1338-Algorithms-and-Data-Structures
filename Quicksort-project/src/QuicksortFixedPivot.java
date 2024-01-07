/**
 * A quicksort algorithm that uses a fixed pivot.
 *
 * @author Farhan Syed
 * @version 2022-03-01
 */
public class QuicksortFixedPivot extends Quicksort implements IntSorter {

    /**
     * Sorts the array using quicksort.
     *
     * @param v An array of ints.
     */
    @Override
    public void sort(int[] v) {
        quickSort(v,0,v.length-1);
    }

    private void quickSort(int[] array, int low, int high){
        if(low < high){
            int pivot = array[high];                               //using the last element as a pivot

            pivot = partition(array,low,high, pivot);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

}
