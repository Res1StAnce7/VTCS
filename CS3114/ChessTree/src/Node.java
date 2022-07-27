public class Node {
    private String entry;
    private int depth;
    private int fitness;
    private Node[] children;
    private int numChildren;
    private String move;
    private String[] moves;

    public Node(String entry, int depth, int fitness, String move, String[] moves) {
        this.entry = entry;
        this.depth = depth;
        this.fitness = fitness;
        this.numChildren = 0;
        this.children = null;
        this.move = move;
        this.moves = moves;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getEntry() {
        return this.entry;
    }

    public void setChildren(Node[] children) {
        this.children = children;
        this.numChildren = children.length;
    }

    public Node getChild(int index) {
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

    public void setMoves(Node node) {
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
