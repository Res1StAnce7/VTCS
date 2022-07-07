/**
 * The class implements a templated linked list
 * 
 * @author Siliang Zhang
 * 
 * @version 2022-05-25
 * 
 * @param <T> The type of the elements in the list
 */
public class LinkedList<T> {
    private Node<T> front;
    private int length;

    /**
     * The constructor of the class which initializes 
     * the front and length to 0
     */
    public LinkedList() {
        this.front = null;
        this.length = 0;
    }

    /**
    * Insert an entry at the specified position
    * 
    * @pre The index is valid
    * @post The entry is added to the list at the index, increasing length by 1
    * @param index position to insert at (1 to length+1)
    * @param entry value/object to add to the list
    */
    public void insert(int index, T entry) {
        if (index < 1 || index > this.length + 1) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> newNode = new Node<T>(entry);
        if (index == 1) {
            newNode.setNext(this.front);
            this.front = newNode;
        } 
        else {
            Node<T> jumper = this.front;
            for (int i = 1; i < index - 1; i++) {
                jumper = jumper.getNext();
            }
            newNode.setNext(jumper.getNext());
            jumper.setNext(newNode);
        }
        this.length++;
    }

    /**
    * @pre The index is valid
    * @post The entry at given position is removed, reducing length by 1 
    * @param index position to remove at (1 to length)
    */  
    public void remove(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        } 
        else if (index < 1 || index > this.length) {
            throw new IndexOutOfBoundsException();
        } 
        else if (index == 1) {
            this.front = this.front.getNext();
        } 
        else {
            Node<T> jumper = this.front;
            for (int i = 2; i < index; i++) {
                jumper = jumper.getNext();
            }
            Node<T> entryAfterIndex = jumper.getNext().getNext();
            jumper.setNext(entryAfterIndex);
        }
        this.length--;
    }

    /**
    * @pre The index is valid
    * @post None 
    * @param index position to get entry at (1 to length)
    * @return entry
    */
    public T getEntry(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        } 
        else if (index < 1 || index > this.length) {
            throw new IndexOutOfBoundsException();
        } 
        else {
            Node<T> jumper = this.front;
            for (int i = 1; i < index; i++) {
                jumper = jumper.getNext();
            }
            return jumper.getEntry();
        }
    }

    /**
    * The function gets the length of the list
    
    * @return The length of the list
    */
    public int length() {
        return this.length;
    }

    /**
     * The function checks if the list is empty
     * 
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.length == 0;
    }
}
