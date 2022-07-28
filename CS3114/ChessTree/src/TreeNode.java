public class TreeNode {
    private String entry;
    private int depth;
    private int fitness;
    private TreeNode[] children;
    private int numChildren;
    private String move;
    private String[] moves;

    public TreeNode(String entry, int depth, int fitness, String move, String[] moves) {
        this.entry = entry;
        this.depth = depth;
        this.fitness = fitness;
        this.numChildren = 0;
        this.children = null;
        this.move = move;
        this.moves = moves;
    }

    public TreeNode(String entry, int depth, int fitness) {
        this.entry = entry;
        this.depth = depth;
        this.fitness = fitness;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getEntry() {
        return this.entry;
    }

    public void setChildren(TreeNode[] children) {
        this.children = children;
        this.numChildren = children.length;
    }

    public TreeNode getChild(int index) {
        return this.children[index];
    }

    public int getDepth() {
        return this.depth;
    }

    public int getFitness() {
        return this.fitness;
    }

    public int getNumChildren() {
        return this.numChildren;
    }

    public String getMove() {
        return this.move;
    }

    public void setMoves(TreeNode node) {
        if (this.depth == 1) {
            this.moves[0] = this.move; 
        }
        else {
            for (int i = 0; i < node.getDepth(); i++) {
                this.moves[i] = node.getMoves()[i];
            }
            this.moves[this.depth - 1] = this.move;
        }
    }

    public String[] getMoves() {
        return this.moves;
    }
}
