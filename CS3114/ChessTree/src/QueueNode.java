public class QueueNode {
    private String entry;
    private int fitness;
    private QueueNode next;
    private String move;
    private String[] moves;
    private int depth;

    public QueueNode(String entry, int fitness, int depth, String move, String[] moves) {
        this.entry = entry;
        this.fitness = fitness;
        this.depth = depth;
        this.next = null;
        this.move = move;
        this.moves = moves;
    }

    public String getEntry() {
        return this.entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public QueueNode getNext() {
        return this.next;
    }  

    public void setNext(QueueNode next) {
        this.next = next;
    }    

    public int getFitness() {
        return this.fitness;
    }

    public String getMove() {
        return this.move;
    }

    public void setMoves(QueueNode node) {
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

    public int getDepth() {
        return this.depth;
    }
}
