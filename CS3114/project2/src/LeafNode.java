/**
 * This class represents a leaf node.
 * 
 * @author Siliang Zhang
 * @version 2022.06.04
 */
public class LeafNode extends DNATreeNode {
    private String sequence;

    /**
     * This function will initializes the sequence to the given sequence.
     * 
     * @param sequence
     *            The DNA sequence
     * @param level
     *            The level
     */
    public LeafNode(String sequence, int level) {
        this.sequence = sequence;
        this.setLevel(level);
    }


    /**
     * This function will return the sequence of this node.
     * 
     * @return The DNA sequence
     */
    public String getSequence() {
        return this.sequence;
    }
}
