/**
 * This class represents an internal node in the tree which
 * points to other InternalNodes or LeafNodes.
 * It will point to A, C, G, T, or a FlyweightNode.
 * 
 * @author Siliang Zhang
 * @version 2022.06.04
 */
public class InternalNode extends DNATreeNode {
    private DNATreeNode a;
    private DNATreeNode c;
    private DNATreeNode g;
    private DNATreeNode t;
    private DNATreeNode e;

    /**
     * Initializes all nodes to the flyweight node.
     * 
     * @param fw
     *            The flyweight node
     * @param level
     *            The level
     */
    public InternalNode(FlyweightNode fw, int level) {
        super();
        this.a = fw;
        this.c = fw;
        this.g = fw;
        this.t = fw;
        this.e = fw;
        setLevel(level);
    }


    /**
     * This function will get the node at the given position.
     * 
     * @param pos
     *            The position
     * @return
     *         The node
     */
    public DNATreeNode getEntry(char pos) {
        switch (pos) {
            case 'A':
                return this.a;
            case 'C':
                return this.c;
            case 'G':
                return this.g;
            case 'T':
                return this.t;

            /**
             * Returns e as the default case.
             */
            default:
                return this.e;
        }
    }


    /**
     * The function will set the node to the given position.
     * 
     * @param node
     *            The node to set
     * @param pos
     *            The position
     */
    public void setEntry(DNATreeNode node, char pos) {
        switch (pos) {
            case 'A':
                this.a = node;
                break;
            case 'C':
                this.c = node;
                break;
            case 'G':
                this.g = node;
                break;
            case 'T':
                this.t = node;
                break;
            case 'E':
                this.e = node;
                break;

            /**
             * The default case but will not be reached.
             */
            default:
                break;
        }
    }


    /**
     * This function will return the count of flyweight nodes.
     * 
     * @return The count of flyweight nodes
     */
    public int getCountOfFw() {
        int count = 0;

        if (a instanceof FlyweightNode) {
            count++;
        }
        if (c instanceof FlyweightNode) {
            count++;
        }
        if (g instanceof FlyweightNode) {
            count++;
        }
        if (t instanceof FlyweightNode) {
            count++;
        }
        if (e instanceof FlyweightNode) {
            count++;
        }
        return count;
    }


    /**
     * This function will return the count of leaf nodes.
     * 
     * @return The count of flyweight nodes
     */
    public int getCountOfLeaf() {
        int count = 0;

        if (a instanceof LeafNode) {
            count++;
        }
        if (c instanceof LeafNode) {
            count++;
        }
        if (g instanceof LeafNode) {
            count++;
        }
        if (t instanceof LeafNode) {
            count++;
        }
        if (e instanceof LeafNode) {
            count++;
        }
        return count;
    }
}
