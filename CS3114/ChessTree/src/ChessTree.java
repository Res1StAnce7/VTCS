public class ChessTree {
    private Node root;
    private int visited;

    public ChessTree(String startBoard) {
        this.root = new Node(startBoard, 0, 
            ChessFaker.getFitness(startBoard), "", new String[1]);
        this.visited = 0;
    }

    public void buildTree(int depth, Node curr) {
        if (curr.getDepth() == depth) {
            return;
        }
        curr.setChildren(genNextBoards(curr));
        for (int i = 0; i < curr.getNumChildren(); i++) {
            buildTree(depth, curr.getChild(i));
        }
    }

    public Node[] genNextBoards(Node board) {
        String[] nextMove = ChessFaker.getNextMoves(board.getEntry());
        Node[] nextBoard = new Node[nextMove.length];
        for (int i = 0; i < nextMove.length; i++) {
            String next = ChessFaker.getNextBoard(board.getEntry(), nextMove[i]);
            nextBoard[i] = new Node(next, board.getDepth() + 1, 
                            ChessFaker.getFitness(next), nextMove[i], new String[board.getDepth() + 1]);
            nextBoard[i].setMoves(board);
        }
        return nextBoard;
    }

    public void printTree(Node curr) {
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

    public int[] dfs(Node node, String target, int depth, int moves) {
        this.visited++;
        if (node.getEntry().equals(target)) {
            return new int[] {visited, moves};
        }
        else if (node.getDepth() == depth) {
            return new int[] {-1, moves};
        }
        else {
            for (int i = 0; i < node.getNumChildren(); i++) {
                int result[] = dfs(node.getChild(i), target, depth, moves + 1);
                if (result[0] != -1) {
                    return result;
                }
            }
            return new int[] {-1, moves};
        }
    }

    public Node getRoot() {
        return this.root;
    }

    public int getVisited() {
        return this.visited;
    }
}
