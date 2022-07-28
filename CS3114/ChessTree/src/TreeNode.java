/**
 * This class represents tree node for preorder print and depth-first search.
 * 
 * @author Siliang Zhang
 * @version 2022.07.28
 */
public class TreeNode extends ChessNode {
    private TreeNode[] children;
    private int numChildren;

    /**
     * The constructor of the TreeNode class.
     * @param entry The board state.
     * @param depth The depth.
     * @param fitness The fitness.
     * @param move The move.
     * @param moves The moves.
     */
    public TreeNode(String entry, int depth, int fitness, String move, String[] moves) {
        this.setEntry(entry);
        this.setFitness(fitness);
        this.setDepth(depth);
        this.setMove(move);
        this.setMoves(moves);
        this.numChildren = 0;
        this.children = null;
    }

    /**
     * The setter for the children.
     * @param children The children.
     */
    public void setChildren(TreeNode[] children) {
        this.children = children;
        this.numChildren = children.length;
    }

    /**
     * The getter for the children.
     * @param index The index of the child.
     * @return The child at the given index.
     */
    public TreeNode getChild(int index) {
        return this.children[index];
    }

    /**
     * The getter for the number of children.
     * @return The number of children.
     */
    public int getNumChildren() {
        return this.numChildren;
    }
}
