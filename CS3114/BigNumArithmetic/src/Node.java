/**
 * The class implements a templated node
 * 
 * @author Siliang Zhang
 * 
 * @version 2022-05-25
  * 
 * @param <T> The type of the elements in the list
 */
public class Node<T> {
    private T entry;
    private Node<T> next;

    /**
     * The constructor of the class which initializes 
     * the entry and next to null
     * 
     * @param entry The entry of the node
     */
    public Node(T entry) {
        this.entry = entry;
        this.next = null;
    }

    /**
     * The function takes an entry and sets it to the entry
     * 
     * @param entry The entry of the node
     */
    public void setEntry(T entry) {
        this.entry = entry;
    }

    /**
     * The function returns the entry
     * 
     * @return the entry
     */
    public T getEntry() {
        return this.entry;
    }

    /**
     * The function takes a node and sets it to the next node
     * 
     * @param next The next node
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * The function returns the next node
     * 
     * @return the next node
     */
    public Node<T> getNext() {
        return this.next;
    }
}
