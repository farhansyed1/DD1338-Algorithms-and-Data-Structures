import java.util.ArrayList;
import java.util.List;
/**
 * A class for reversing List and array types.
 *
 * @author Farhan Syed
 * @version 2021-12-08
 */
public class Reverse {

    /**
     * Return a reversed copy of the argument array.
     * The passed array is NOT mutated.
     *
     * @param array An array.
     * @return A reversed copy of array.
     */
    public int[] reversed(int[] array) {
        int[] copy = array.clone();
        int length = copy.length;
        for (int i = 0; i <= array.length-1; i++) {
            copy[length-1] = array[i];
            length--;
        }
        return copy;
    }

    /**
     * Return a reversed copy of the argument List.
     * The passed List is NOT mutated.
     *
     * @param list A List.
     * @return A reversed copy of list.
     */
    public List<Integer> reversed(List<Integer> list) {
        List<Integer> copy = new ArrayList<>(list);
        int length = copy.size();
        for (int i = 0; i <= copy.size()-1; i++) {
            copy.set(length-1, list.get(i));
            length--;
        }
        return copy;
    }
}
