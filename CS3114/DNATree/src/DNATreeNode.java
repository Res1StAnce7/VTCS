/**
 * This class represents
 * a general tree node in the DNA tree.
 * 
 * @author Siliang Zhang
 * @version 2022.06.04
 */
public class DNATreeNode {
    private int level = 0;

    /**
     * This function will return the level of the node.
     * 
     * @return The level
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * This function will set the level of node.
     * 
     * @param level
     *            The new level
     */
    public void setLevel(int level) {
        this.level = level;
    }


    /**
     * This function will decrease the level by 1.
     */
    public void decrementLevel() {
        this.level--;
    }

    /**
     * This function will increase the level by 1.
     */
    public void incrementLevel() {
        this.level++;
    }
}
