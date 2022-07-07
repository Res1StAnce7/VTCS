import java.io.IOException;

/**
 * This class represents a max heap which contains records.
 * 
 * @author Siliang Zhang
 * @version 06/22/2022
 */
public class MaxHeap {
    private int size;
    private BufferPool pool;

    /**
     * Constructor for the max heap.
     * 
     * @param pool 
     *          the buffer pool.
     * @param size 
     *          the size of the heap.
     * @throws IOException 
     *          if an I/O error occurs.
     */
    public MaxHeap(BufferPool pool, int size) throws IOException {
        this.size = size;
        this.pool = pool;
        buildHeap();
    }


    /**
     * Get the index of the left child of the given index.
     * 
     * @param pos
     *          the index.
     */
    private int leftChild(int pos) {
        return 2 * pos + 1;
    }


    /**
     * Get the index of the right child of the given index.
     * 
     * @param pos
     *          the index.
     */
    private int rightChild(int pos) {
        return 2 * pos + 2;
    }


    /**
     * Check if the given index is a leaf.
     * 
     * @param pos
     *            the index.
     * @return true if the index is a leaf, false otherwise.
     */
    private boolean isLeaf(int pos) {
        return pos >= (size / 2) && pos <= size;
    }


    /**
     * Siftdown elements.
     * 
     * @param pos 
     *          the index.
     * @param flag 
     *          the operation flag.
     * @throws IOException 
     *          if there is an error.
     */
    public void siftDown(int pos, int flag) throws IOException {
        if (isLeaf(pos)) {
            return;
        }
        Buffer curr = pool.getBuffer(pos * 4, flag);
        short numCurr = curr.getShort(pos * 4);
        Buffer left = pool.getBuffer(leftChild(pos) * 4, flag);
        Buffer right = pool.getBuffer(rightChild(pos) * 4, flag);
        short numL = left.getShort(leftChild(pos) * 4);
        short numR = right.getShort(rightChild(pos) * 4);

        if (leftChild(pos) < this.size && rightChild(pos) < this.size) {
            if (numCurr < numL || numCurr < numR) {
                if (numL > numR) {
                    pool.swap(pos * 4, leftChild(pos) * 4);
                    pos = leftChild(pos);
                } 
                else {
                    pool.swap(pos * 4, rightChild(pos) * 4);
                    pos = rightChild(pos);
                }
                siftDown(pos, flag);
            } 
        } 
        else if (leftChild(pos) < this.size
                && rightChild(pos) >= this.size) {
            if (numCurr < numL) {
                pool.swap(pos * 4, leftChild(pos) * 4);
                pos = leftChild(pos);
                siftDown(pos, flag);
            } 
        } 
        else if (numCurr < numR) {
            pool.swap(pos * 4, rightChild(pos) * 4);
            pos = rightChild(pos);
            siftDown(pos, flag);
        } 
    }

    /**
     * Swap the two records and hide the one at the end.
     * 
     * @throws IOException 
     *          if an I/O error occurs.
     */
    public void swapAndHide() throws IOException {
        while (this.size >= 1) {
            pool.swap(0, (this.size - 1) * 4);
            this.size--;
            siftDown(0, 0);
        }
    }


    /**
     * Make the binary a max heap
     * 
     * @throws IOException 
     *          if an I/O error occurs.
     */
    public void buildHeap() throws IOException {
        for (int i = (this.size / 2) - 1; i >= 0; i--) {
            siftDown(i, 0);
        }
    }


    /**
     * The main sorting method.
     * 
     * @throws IOException 
     *          if an I/O error occurs.
     */
    public void sort() throws IOException {
        swapAndHide();
        pool.flush();
    }
}
