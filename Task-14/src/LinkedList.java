import java.util.NoSuchElementException;

/**
 * A singly linked list.
 * 
 * @author Farhan Syed
 * @version 2022.01.27
 */
public class LinkedList<T> { 
    private ListElement<T> first;   // First element in list.
    private ListElement<T> last;    // Last element in list.
    private int size;               // Number of elements in list.
    
    /**
     * A list element.
     */
    private static class ListElement<T> {
        public T data;
        public ListElement<T> next;
        
        public ListElement(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Creates an empty list.
     *
     */
    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Inserts the given element at the beginning of this list.
     *
     * Time complexity: O(1)
     *
     * @param element An element to insert into the list.
     */
    public void addFirst(T element) {
        ListElement<T> newElement = new ListElement<T>(element);

        if(size == 0){                       //In an empty list, the new element becomes both first and last.
            last = newElement;
        }
        else{
            newElement.next = first;        //The new element is placed before the previous "first"
        }
        first = newElement;                 //The new element becomes the new "first"
        size++;
    }

    /**
     * Inserts the given element at the end of this list.
     *
     * Time complexity: O(1)
     *
     * @param element An element to insert into the list.
     */
    public void addLast(T element) {
        ListElement<T> newElement = new ListElement<T>(element);

        if(size == 0){                      //In an empty list, the new element becomes both first and last.
            first = newElement;
        }
        else{
            last.next = newElement;         //The new element is placed after the previous "last"
        }
        last = newElement;                  //The new element becomes the new "last"
        size++;
    }

    /**
     * Gets the first element in the list
     *
     * Time complexity: O(1)
     *
     * @return The head of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getFirst() {
        if (size != 0) {
            return first.data;
        }
        throw new NoSuchElementException();
    }

    /**
     * Gets the last element of the list
     *
     * Time complexity: O(1)
     *
     * @return The tail of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getLast() {
        if (size != 0) {
            return last.data;
        }
        throw new NoSuchElementException();
    }

    /**
     * Returns an element from a specified index.
     *
     * Time complexity: O(n)
     *
     * @param index A list index.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public T get(int index) {
        if(index < size && index >= 0){
            ListElement<T> element = first;
            for (int i = 0; i < index; i++) {
                element = element.next;
            }
            return element.data;
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * Removes the first element from the list.
     *
     * Time complexity: O(1)
     *
     * @return The removed element.
     * @throws NoSuchElementException if the list is empty.
     */
    public T removeFirst() {
        if(size == 1){
            T oldFirstData = first.data;         //Store the first element's data
            clear();                            //Used to give both first and last the value "null"
            return oldFirstData;                //return the stored element's data
        }
        else if(size != 0){
            T oldFirstData = first.data;
            first = first.next;                 //The second element becomes the new "first"
            size--;
            return oldFirstData;
        }
        throw new NoSuchElementException();
    }

    /**
     * Removes all of the elements from the list.
     *
     * Time complexity: O(1)
     */
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Get the size of the list
     *
     * Time complexity: O(1)
     *
     * @return The number of elements in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Note that by definition, the list is empty if both first and last
     * are null, regardless of what value the size field holds (it should
     * be 0, otherwise something is wrong).
     *
     * Time complexity: O(1)
     *
     * @return <code>true</code> if this list contains no elements.
     */
    public boolean isEmpty() {
        return first == null && last == null;
    }

    /**
     * Creates a string representation of this list. The string
     * representation consists of a list of the elements enclosed in
     * square brackets ("[]"). Adjacent elements are separated by the
     * characters ", " (comma and space). Elements are converted to
     * strings by the method toString() inherited from Object.
     *
     * Examples:
     *  "[1, 4, 2, 3, 44]"
     *  "[]"
     *
     *
     *  Time complexity: O(n)
     *
     * @return A string representing the list.
     */
    public String toString() {
        if(size == 0){
            return "[]";
        }
        else{
            String list = "[";
            ListElement<T> element = first;
            for (int i = 0; i < size-1; i++) {
                list += element.data + ", ";
                element = element.next;
            }
            list += element.data + "]";
            return list;
        }
    }
}
