/**
 * This class represents queue node for breadth-first search.
 * 
 * @author Siliang Zhang
 * @version 2022.07.28
 */
public class QueueNode extends ChessNode {
    private QueueNode next;

    /**
     * The constructor of the QueueNode class.
     * @param entry The board state.
     * @param fitness The fitness.
     * @param depth The depth.
     * @param move The move.
     * @param moves The moves.
     */
    public QueueNode(String entry, int fitness, int depth, String move, String[] moves) {
        this.setEntry(entry);
        this.setFitness(fitness);
        this.setDepth(depth);
        this.setMove(move);
        this.setMoves(moves);
        this.next = null;
    }

    /**
     * The getter method for the next board.
     * @return The next board.
     */
    public QueueNode getNext() {
        return this.next;
    }  

    /**
     * The setter method for the next board.
     * @param next The next board.
     */
    public void setNext(QueueNode next) {
        this.next = next;
    }    
}
