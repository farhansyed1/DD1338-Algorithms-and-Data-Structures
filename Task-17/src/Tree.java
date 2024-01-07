import java.lang.Comparable;

import static java.lang.Math.max;

/**
 * A binary search tree.
 *
 * @author Farhan Syed
 * @version 2022-02-17
 */
public class Tree<T extends Comparable<T>>  {

    private Node<T> root;
    private int size;

    private class Node<T>{
        public T data;
        public Node<T> left;
        public Node<T> right;

        public Node(T data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    /**
     * Creates an empty tree
     *
     */
    public Tree(){
        size = 0;
        root = null;
    }

    /**
     * Searches for an element in the tree.
     *
     * @param elem the element that is searched for
     * @return "true" if the element is found, otherwise "false"
     */
    public boolean search(T elem){
        if(root == null || elem == null){
            return false;
        }
        Node<T> currentNode = root;

        while(currentNode.data != null){
            //Element is less than the current node --> Go left
            if(elem.compareTo(currentNode.data) < 0){
                if(currentNode.left == null) return false;              //No element to the left means that the element is not in the tree
                currentNode = currentNode.left;                         //Traversing to the left element
            }
            //Element is greater than the current node --> Go right
            else if(elem.compareTo(currentNode.data) > 0){
                if(currentNode.right == null) return false;
                currentNode = currentNode.right;
            }
            //Element is found
            else {
                return true;
            }
        }
        return false;
    }

    /**
     * Inserts a unique element in the tree
     *
     * @param elem the element that is inserted
     * @return "true" if the element is inserted, "false" is the element is a duplicate
     */
    public boolean insert(T elem){
        if(elem == null){
            return false;
        }
        else if(root == null){
            root = new Node<>(elem);
            size++;
            return true;
        }

        Node<T> currentNode = root;

        while(currentNode.data != null){
            //Element is less than the current node --> Go left
            if(elem.compareTo(currentNode.data) < 0){
                //If the left node is empty, the element is inserted here
                if(currentNode.left == null) {
                    currentNode.left = new Node<>(elem);
                    size++;
                    return true;
                }
                //Otherwise, traverse to the left
                currentNode = currentNode.left;
            }
            //Element is greater than the current node --> Go right
            else if(elem.compareTo(currentNode.data) > 0){
                //If the right node is empty, the element is inserted here
                if(currentNode.right == null) {
                    currentNode.right = new Node<>(elem);
                    size++;
                    return true;
                }
                //Otherwise, traverse to the right
                currentNode = currentNode.right;
            }
            //The element is a duplicate
            else{
                return false;
            }
        }
        return false;
    }

    /**
     * Gets the size of the tree
     *
     * @return size of the tree
     */
    public int size(){
        return size;
    }

    /**
     * Gets the height of the tree
     *
     * @return height of the tree
     */
    public int height(){
        if(root == null) return 0;                                  //If root is empty
        else if(root.left == null && root.right == null) return 0;  //If root is the only node

        return calculateHeight((root));
    }

    private int calculateHeight(Node<T> node){
        if(node == null) return -1;                                 //The node is empty (base case)

        return max(calculateHeight(node.left), calculateHeight(node.right)) + 1;
    }

    /**
     * Gets the number of leaves in the tree
     *
     * @return the number of leaves
     */
    public int leaves(){
        if(root == null) return 0;                                  //If root is empty

        return calculateNumberOfLeaves(root);
    }

    private int calculateNumberOfLeaves(Node<T> node){
        if(node == null) return 0;                                  //The node is empty
        if(node.left == null && node.right == null) return 1;       //The node is a leaf

        return calculateNumberOfLeaves(node.left) + calculateNumberOfLeaves(node.right);
    }

    /**
     * Gets a string describing the tree
     *
     * @return a string containing the tree's nodes in ascending order
     */
    public String toString(){
        if(root == null) return "[]";
        return "[" + createString(root).substring(1).trim() + "]";
    }

    private String createString(Node<T> node){
        StringBuilder treeString = new StringBuilder();
        if(node != null) {
            treeString.append(createString(node.left) + ", ");
            treeString.append(node.data);
            treeString.append(createString(node.right));
        }
        else {
            return "";
        }

        return treeString.toString().trim();
    }

}
