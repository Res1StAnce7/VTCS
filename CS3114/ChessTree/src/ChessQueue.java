public class ChessQueue {
    private QueueNode front;
    private QueueNode rear;
    private int visited;

    public ChessQueue(String startBoard) {
        this.front = new QueueNode(startBoard, ChessFaker.getFitness(startBoard),
            0, "", new String[1]);
        this.rear = this.front;
        this.visited = -1;
    }

    public void enqueue(QueueNode node) {
        QueueNode temp = this.rear;
        this.rear = node;
        temp.setNext(this.rear);
    }

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
    
    public QueueNode bfs(QueueNode node, String start) {
        this.visited++;
        for (int i = 0; i < genNextBoards(node).length; i++) {
            enqueue(genNextBoards(node)[i]);
        }
        if (ChessFaker.getFitness(node.getEntry()) - ChessFaker.getFitness(start) >= 130) {
            return node;
        }
        return bfs(node.getNext(), start);
    }

    public QueueNode getFront() {
        return this.front;
    }

    public int getVisited() {
        return this.visited;
    }
}
