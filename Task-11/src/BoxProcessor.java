import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The BoxProcessor class contains sorting and searching methods for the Box class
 *
 * @author  Farhan Syed
 * @version 2021-12-02
 */
public class BoxProcessor {

    public static void main(String[] args) {
        BoxProcessor processor = new BoxProcessor();
        Box[] array = new Box[5];

        array[0] = new Box(4,4,4);
        array[1] = new Box(5,5,5);
        array[2] = new Box(1,1,1);
        array[3] = new Box(3,3,3);
        array[4] = new Box(2,2,2);

        List<Box> list = new ArrayList<Box>();
        list.add(new Box(3,3,3));
        list.add(new Box(1,1,1));
        list.add(new Box(5,5,5));
        list.add(new Box(4,4,4));
        list.add(new Box(2,2,2));

        processor.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));

        processor.sort(list);
        System.out.println("Sorted List: " + list);
    }

    /**
     * Uses an insertion sort to order arrays containing Box objects
     *
     * @param array an array of Box objects
     */
    public void sort(Box[] array){
        int j;
        Box temp;
        for (int i = 1; i <= array.length-1; i++) {
            j = i;
            while(j > 0 && array[j-1].compareTo(array[j]) == 1){
                temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                j = j - 1;
            }
        }
    }

    /**
     * Uses an insertion sort to order lists containing Box objects
     *
     * @param list a list of Box objects
     */
    public void sort(List<Box> list){
        int j;
        Box temp;
        for (int i = 1; i <= list.size()-1; i++) {
            j = i;
            while(j > 0 && list.get(j-1).compareTo(list.get(j)) == 1){
                temp = list.get(j);
                list.set(j, list.get(j-1));
                list.set(j-1, temp);
                j = j - 1;
            }
        }
    }

    /**
     * Sequentially searches for a given Box object in a given array
     *
     * @param array an array of Box objects
     * @param box   a Box object to be searched for
     * @return      if the object is found, returns the position of the object in the array
     *              otherwise, returns -1
     */
    public int sequentialSearch(Box[] array, Box box){
        for (int i = 0; i <= array.length-1; i++) {
            if(box.compareTo(array[i]) == 0){
                return i;
            }
        }
        return -1;
    }

    /**
     * Sequentially searches for a given Box object in a given list
     * @param list  a list of Box objects
     * @param box   a Box object to be searched for
     * @return      if the object is found, returns the position of the object in the list
     *              otherwise, returns -1
     */
    public int sequentialSearch(List<Box> list, Box box){
        for (int i = 0; i <= list.size()-1; i++) {
            if(box.compareTo(list.get(i)) == 0){
                return i;
            }
        }
        return -1;
    }

    /**
     * Uses a binary search method to search for a given Box object in a sorted array
     *
     * @param array a sorted array of Box objects
     * @param box   a Box object to be searched for
     * @return      if the object is found, returns the position of the object in the array
     *              otherwise, returns -1
     */
    public int binarySearch(Box[] array, Box box){
        int mid;
        int low = 0;
        int high = array.length-1;
        while(low <= high){
            mid = (low + high) / 2;
            if(array[mid].compareTo(box) == 0){
                return mid;
            }
            else if(array[mid].compareTo(box) == 1){
                high = mid - 1;
            }
            else if(array[mid].compareTo(box) == -1){
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * Uses a binary search method to search for a given Box object in a sorted list
     *
     * @param list  a sorted list of Box objects
     * @param box   a Box object to be searched for
     * @return      if the object is found, returns the position of the object in the list
     *              otherwise, returns -1
     */
    public int binarySearch(List<Box> list, Box box){
        int mid;
        int low = 0;
        int high = list.size()-1;
        while(low <= high){
            mid = (low + high) / 2;
            if(list.get(mid).compareTo(box) == 0){
                return mid;
            }
            else if(list.get(mid).compareTo(box) == 1){
                high = mid - 1;
            }
            else if(list.get(mid).compareTo(box) == -1){
                low = mid + 1;
            }
        }
        return -1;
    }

}
