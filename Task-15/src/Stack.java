/**
 * An interface for a stack
 *
 * @author Farhan Syed
 * @version 2022-02-01
 */

public interface Stack<T> {

    /**
     * Inserts the given element at the top of the stack.
     *
     * @param element the new top element
     */
    void push(T element);

    /**
     * Removes the top element from the stack.
     *
     * @return The removed element.
     */
    T pop();

    /**
     * Gets the top element in the stack.
     *
     * @return  The top of the stack.
     */
    T top();

    /**
     * Get the size of the stack.
     *
     * @return The number of elements in the stack.
     */
    int size();

    /**
     * Check if the stack is empty.
     *
     * @return "True" if the stack is empty
     */
    boolean isEmpty();

}
