import java.util.EmptyStackException;

/**
 * A stack.
 *
 * @author  Farhan Syed
 * @version 2022-02-01
 */
public class LinkedList<T> implements Stack<T> {

    private ListElement<T> top;      // Top element in stack.
    private int size;               // Number of elements in stack.

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
     * Creates an empty stack.
     *
     */
    public LinkedList() {
        top = null;
        size = 0;
    }

    /**
     * Inserts the given element at the top of the stack
     *
     * @param element An element to insert into the stack.
     */
    @Override
    public void push(T element) {
        ListElement<T> newElement = new ListElement<T>(element);
        newElement.next = top;            //The new element is placed before the previous "top"
        top = newElement;                 //The new element becomes the new "top"
        size++;
    }

    /**
     * Removes the top element from the stack.
     *
     * @return The removed element.
     * @throws EmptyStackException if the stack is empty.
     */
    @Override
    public T pop() {
        if(size == 1){
            T oldTopData = top.data;             //Store the top element's data
            top = null;
            size = 0;
            return oldTopData;                   //return the stored element's data
        }
        else if(size != 0){
            T oldTopData = top.data;
            top = top.next;                     //The second element becomes the new "top"
            size--;
            return oldTopData;
        }
        throw new EmptyStackException();
    }

    /**
     * Gets the top element in the stack
     *
     * @return The top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    @Override
    public T top() {
        if (size != 0) {
            return top.data;
        }
        throw new EmptyStackException();
    }

    /**
     * Get the size of the stack.
     *
     * @return The number of elements in the stack.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Note that by definition, the stack is empty if top is null,
     * regardless of what value the size field holds (it should
     * be 0, otherwise something is wrong).
     *
     * @return <code>true</code> if this stack contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }

}
