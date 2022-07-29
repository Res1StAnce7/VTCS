/**
 * The abstract class ChessNode.
 * 
 * @author Siliang Zhang
 * @version 2022.07.28
 */
public abstract class ChessNode {
    private String entry;
    private int fitness;
    private String move;
    private String[] moves;
    private int depth;

    /**
     * Constructor for ChessNode.
     * @param entry The board state.
     */
    public void setEntry(String entry) {
        this.entry = entry;
    }

    /**
     * The getter method for the board state.
     * @return The board state.
     */
    public String getEntry() {
        return this.entry;
    }

    /**
     * The getter method for the depth.
     * @return The depth.
     */
    public int getDepth() {
        return this.depth;
    }

    /**
     * The setter method for the fitness.
     * @param fitness The fitness.
     */
    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    /**
     * The setter method for the depth.
     * @param depth The depth.
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * The setter method for the move.
     * @param move The move.
     */
    public void setMove(String move) {
        this.move = move;
    }

    /**
     * The getter method for the fitness.
     * @return The fitness.
     */
    public int getFitness() {
        return this.fitness;
    }

    /**
     * The getter method for the move.
     * @return The move.
     */
    public String getMove() {
        return this.move;
    }

    /**
     * The getter method for the moves.
     * @return The moves.
     */
    public String[] getMoves() {
        return this.moves;
    }

    /**
     * The first setter method for the moves.
     * @param move The moves.
     */
    public void setMoves(String[] moves) {
        this.moves = moves;
    }

    /**
     * The second setter method for the moves.
     * @param move The moves.
     */
    public void setMoves(ChessNode node) {
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
}
