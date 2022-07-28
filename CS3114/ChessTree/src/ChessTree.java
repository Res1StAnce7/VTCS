/**
 * This class will perform preorder search and
 * depth-first search.
 * 
 * @author Siliang Zhang
 * @version 2022.07.28
 */
public class ChessTree {
    private TreeNode root;
    private int visited;

    /**
     * The constructor of the ChessTree class.
     * @param startBoard The start board.
     */
    public ChessTree(String startBoard) {
        this.root = new TreeNode(startBoard, 0, 
            ChessFaker.getFitness(startBoard), "", new String[1]);
        this.visited = 0;
    }

    /**
     * Buiild the tree based on the depth limit.
     * @param depth The depth limit.
     * @param curr The current node.
     */
    public void buildTree(int depth, TreeNode curr) {
        if (curr.getDepth() == depth) {
            return;
        }
        curr.setChildren(genNextBoards(curr));
        for (int i = 0; i < curr.getNumChildren(); i++) {
            buildTree(depth, curr.getChild(i));
        }
    }

    /**
     * Generate next boards.
     * @param board The current board.
     * @return The next boards.
     */
    private TreeNode[] genNextBoards(TreeNode board) {
        String[] nextMove = ChessFaker.getNextMoves(board.getEntry());
        TreeNode[] nextBoard = new TreeNode[nextMove.length];
        for (int i = 0; i < nextMove.length; i++) {
            String next = ChessFaker.getNextBoard(board.getEntry(), nextMove[i]);
            nextBoard[i] = new TreeNode(next, board.getDepth() + 1, 
                            ChessFaker.getFitness(next), nextMove[i], new String[board.getDepth() + 1]);
            nextBoard[i].setMoves(board);
        }
        return nextBoard;
    }

    /**
     * Print the tree in preorder.
     * @param curr The current board.
     */
    public void printTree(TreeNode curr) {
        if (curr.getDepth() == 0) {
            System.out.println(curr.getEntry() + " fitness: " + curr.getFitness());
        }
        else {
            for (int i = 0; i < curr.getMoves().length; i++) {
                System.out.print(" + "+ curr.getMoves()[i]);
            }
            System.out.println(" = " + curr.getEntry()+ " fitness: " + curr.getFitness());
        }
        for (int i = 0; i < curr.getNumChildren(); i++) {
            printTree(curr.getChild(i));
        }
    }

    /**
     * Find the target board.
     * @param curr The current board.
     * @param start The start board.
     * @param depth The depth limit.
     * @return The win board.
     */
    public TreeNode dfs(TreeNode curr, String target, int depth) {
        this.visited++;
        if (curr.getEntry().equals(target)) {
            return curr;
        }
        else if (curr.getDepth() == depth) {
            return null;
        }
        else {
            for (int i = 0; i < curr.getNumChildren(); i++) {
                TreeNode node = dfs(curr.getChild(i), target, depth);
                if (node != null) {
                    return node;
                }
            }
            return null;
        }
    }

    /**
     * The getter method for the root board.
     * @return The root board.
     */
    public TreeNode getRoot() {
        return this.root;
    }

    /**
     * Get the visted counter.
     * @return The visited counter.
     */
    public int getVisited() {
        return this.visited;
    }
}
