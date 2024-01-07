/**
 * The parent class for the quicksort implementations
 *
 *  @author Farhan Syed
 *  @version 2022-03-18
 */
abstract class Quicksort {

    /**
     * Partitions the array into smaller arrays that contain elements that are less than or greater than the pivot.
     *
     * @param array     the array that is partitioned
     * @param low       the lower boundary
     * @param high      the upper boundary
     * @param pivot     the pivot that is used
     * @return          the correct position of the pivot
     */
    public int partition(int[] array, int low, int high, int pivot){
        int i = low - 1;                            //i starts at position -1.

        for (int j = low; j <= high-1; j++) {      //j starts at position 0 in array.
            //Swap if less than pivot
            if(array[j] <= pivot){
                i++;                                //i only advances if we perform swap
                swap(i, j,array);
            }
        }
        //Swap pivot into correct position
        swap(i+1, high,array);

        return i+1;
    }

    /**
     * Swaps two values in an array
     *
     * @param i     the index of the first value
     * @param j     the index of the second value
     * @param array the array that will have two of its values swapped
     */
    public void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * An insertion sort that is used by Quicksort algorithms for small arrays.
     *
     * @param array     the array that is sorted with insertion sort
     * @param low       the lower boundary
     * @param high      the upper boundary
     */
    public void iSort(int[] array, int low, int high){
        int j;
        int temp;
        for (int i = low+ 1; i < high; i++) {
            temp = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }
    }

}
