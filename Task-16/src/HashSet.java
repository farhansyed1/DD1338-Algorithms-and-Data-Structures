import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A hash table-based implementation of the Set interface.
 *
 * @author Farhan Syed
 * @version 2022-02-09
 */
public class HashSet<T> implements Set<T> {
    private List<T>[] table;
    private int size;

    /**
     * Creates a hash table with the given capacity (amount of buckets).
     *
     * @throws IllegalArgumentException if capacity <= 0.
     */
    public HashSet(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                "capacity must be a positive, non-zero value! Provided: " + capacity);
        }

        // We want to do the following:
        //
        //     table = new LinkedList<String>[capacity];
        //
        // However, that won't compile ("generic array creation")
        // since Java generics and arrays don't get along very well.
        // Instead we need to do the following:
        //
        //     table = new LinkedList[capacity];
        //
        // The above will compile, but with a warning. The proper
        // approach is to document why the warning can be safely
        // ignored and then suppress the warning. Thus:

        /*
         * This array will contain only LinkedList<T>
         * instances, all created in the add method. This
         * is sufficient to ensure type safety.
         */
        @SuppressWarnings("unchecked") // for this declaration only
        List<T>[] t = new LinkedList[capacity];

        table = t;
    }

    /**
     * Adds the given element to the set.
     *
     * Complexity: O(1) expected time.
     *
     * @param elem An element to add to the set.
     * @return true if the set did not contain the element, otherwise false.
     */
    public boolean add(T elem) {
        int hashOfElem = Math.abs(elem.hashCode() % table.length);

        //Filling an empty bucket
        if(table[hashOfElem] == null) {
            table[hashOfElem] = new LinkedList<T>();
            table[hashOfElem].add(elem);
            size++;
            return true;
        }
        //Bucket does not contain the element
        if(!table[hashOfElem].contains(elem)){
            table[hashOfElem].add(elem);
            size++;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Removes the given element from the dictionary, if it is present.
     *
     * Complexity: O(1) expected time.
     *
     * @param elem An element to remove from the set.
     * @return true if the set contained the element, false otherwise.
     */
    public boolean remove(T elem) {
        int hashOfElem = Math.abs(elem.hashCode() % table.length);
        //Empty set
        if(table[hashOfElem] == null) {
            return false;
        }
        //Set contains element
        else if(table[hashOfElem].contains(elem)){
            table[hashOfElem].remove(elem);
            size--;
            return true;
        }
        return false;
    }

    /**
     * Check if an element is in the Set.
     *
     * Complexity: O(1) expected time.
     *
     * @param elem An element to look for.
     * @return true if the element is in the set, false otherwise.
     */
    public boolean contains(T elem) {
        int hashOfElem = Math.abs(elem.hashCode() % table.length);
        //Empty set
        if(table[hashOfElem] == null) {
            return false;
        }
        //Set contains element
        else return table[hashOfElem].contains(elem);
    }

    /**
     * Returns the number of elements in this set.
     *
     * Complexity: O(1) expected time.
     *
     * @return The amount of elements in this set.
     */
    public int size() {
        return size;
    }
}
