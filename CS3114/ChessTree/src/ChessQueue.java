public class ChessQueue {
    private QueueNode front;
    private QueueNode rear;
    private int visited;

    public ChessQueue(String startBoard) {
        this.front = new QueueNode(startBoard, ChessFaker.getFitness(startBoard));
        this.rear = this.front;
        this.visited = -1;
    }

    public void enqueue(QueueNode node) {
        QueueNode temp = this.rear;
        this.rear = node;
        temp.setNext(this.rear);
    }

    public QueueNode[] genNextBoards(QueueNode board) {
        String[] nextMove = ChessFaker.getNextMoves(board.getEntry());
        QueueNode[] nextBoard = new QueueNode[nextMove.length];
        for (int i = 0; i < nextMove.length; i++) {
            String next = ChessFaker.getNextBoard(board.getEntry(), nextMove[i]);
            nextBoard[i] = new QueueNode(next, ChessFaker.getFitness(next));
        }
        return nextBoard;
    }
    
    public String[] bfs(QueueNode node, String start, int moves) {
        this.visited++;
        for (int i = 0; i < genNextBoards(node).length; i++) {
            enqueue(genNextBoards(node)[i]);
        }
        if (ChessFaker.getFitness(start) - ChessFaker.getFitness(node.getEntry()) >= 40) {
            return new String[] {String.valueOf(moves), node.getEntry(), String.valueOf(this.visited)};
        }
        return bfs(node.getNext(), start, moves + 1);
    }

    public QueueNode peek() {
        return this.front;
    }

    public int getVisited() {
        return this.visited;
    }
}
