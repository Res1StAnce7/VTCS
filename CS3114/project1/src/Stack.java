/**
 * The class implements a templated stack
 * 
 * @author Siliang Zhang
 * 
 * @version 2022-05-25
 * 
 * @param <T> The type of the elements in the list
 */
public class Stack<T> {
    private Node<T> top;
    private int size;

    /**
     * The constructor of the class which initializes 
     * the top and size to null
     */
    public Stack() {
        this.top = null;
        this.size = 0;
    }

    /** 
    * @pre None
    * @post entry is added to top of the stack
    * @param entry the element to be added to the stack
    **/
    public void push(T entry) {
        if (isEmpty()) {
            this.top = new Node<T>(entry);
        } 
        else {
            Node<T> temp = this.top;
            this.top = new Node<T>(entry);
            this.top.setNext(temp);
        }
        this.size++;
    }

    /** 
    * @pre Stack is non-empty
    * @post Top element is removed from the stack
    **/
    public void pop() {
        if (!isEmpty()) {
            this.top = this.top.getNext();
            this.size--;
        }
    }

    /**
     * The function checks if the stack is empty
     * 
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return (this.top == null);
    }

    /** 
    * @pre Stack is non-empty
    * @post To return the Top element
    * @return The top element 
    **/
    public T peek() {
        if (!isEmpty()) {
            return this.top.getEntry();
        }
        return null;
    }
    
    /**
     * The function returns the size of the stack
     *
     * @return The size of the stack
     */
    public int size() {
        return this.size;
    }
}
