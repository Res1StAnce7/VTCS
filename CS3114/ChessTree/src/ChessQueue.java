/**
 * This class will perform breadth-first search.
 * 
 * @author Siliang Zhang
 * @version 2022.07.28
 */
public class ChessQueue {
    private QueueNode front;
    private QueueNode rear;
    private int visited;
    
    /**
     * The constructor of the ChessQueue class.
     * @param startBoard The start board.
     */
    public ChessQueue(String startBoard) {
        this.front = new QueueNode(startBoard, ChessFaker.getFitness(startBoard),
            0, "", new String[1]);
        this.rear = this.front;
        this.visited = 0;
    }

    /**
     * Add a board to the queue.
     * @param node The board to be added.
     */
    public void enqueue(QueueNode node) {
        QueueNode temp = this.rear;
        this.rear = node;
        temp.setNext(this.rear);
    }

    /**
     * Remove the starting board from the queue.
     * @param board
     */
    public void dequeue() {
        this.front = this.front.getNext();
    }

    /**
     * Generate the next boards.
     * @param board The current board.
     * @return The next boards.
     */
    private QueueNode[] genNextBoards(QueueNode board) {
        String[] nextMove = ChessFaker.getNextMoves(board.getEntry());
        QueueNode[] nextBoard = new QueueNode[nextMove.length];
        for (int i = 0; i < nextMove.length; i++) {
            String next = ChessFaker.getNextBoard(board.getEntry(), nextMove[i]);
            nextBoard[i] = new QueueNode(next, ChessFaker.getFitness(next), 
                            board.getDepth() + 1, nextMove[i], new String[board.getDepth() + 1]);
            nextBoard[i].setMoves(board);
        }
        return nextBoard;
    }
    
    /**
     * Find the win board.
     * @param curr The current board.
     * @param start The start board.
     * @return The win board.
     */
    public QueueNode bfs(QueueNode curr, String start) {
        if (curr != this.front) {
            dequeue();
        }
        this.visited++;
        for (int i = 0; i < genNextBoards(curr).length; i++) {
            enqueue(genNextBoards(curr)[i]);
        }
        if (ChessFaker.getFitness(curr.getEntry()) - ChessFaker.getFitness(start) >= 160) {
            return curr;
        }
        return bfs(curr.getNext(), start);
    }

    /**
     * Get the front board in the queue.
     * @return The front board.
     */
    public QueueNode getFront() {
        return this.front;
    }

    /**
     * Get the visted counter.
     * @return The visited counter.
     */
    public int getVisited() {
        return this.visited;
    }
}
