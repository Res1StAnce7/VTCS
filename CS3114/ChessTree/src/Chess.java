/**
 * The main class of the Chess project which involves preorder print,
 * depth-first search, and breadth-first search.
 * 
 * @author Siliang Zhang
 * @version 2022.07.28
 */
public class Chess {
    private ChessTree tree;
    private ChessQueue queue;

    /**
     * The main method of the Chess project.
     * @param args the command line arguments.
     * @throws Exception The exception.
     */
    public static void main(String[] args) throws Exception {
        runTask(2, 0, "ViannaSpen", "ViannaSpe");
        //runTask(3, 5, "quickWin", "VienngOSen");
    }

    /**
     * The first constructor of the Chess class.
     * @param depth The depth limit.
     * @param start The start board.
     */
    public Chess(int depth, String start) {
        this.tree = new ChessTree(start);
        this.tree.buildTree(depth, tree.getRoot()); 
    }

    /**
     * The second constructor of the Chess class.
     * @param start The start board.
     */
    public Chess(String start) {
        this.queue = new ChessQueue(start);
    }

    /**
     * Hepler method to run three tasks.
     * @param index The index of the task.
     * @param depth The depth limit.
     * @param start The start board.
     * @param target The target board.
     */
    public static void runTask(int index, int depth, String start, String target) {
        if (index == 1 || index == 2) {
            Chess chess = new Chess(depth, start);
            if (index == 1) {
                chess.print();
            }
            else {
                chess.dfs(start, target, depth);
            }
        }
        else {
            Chess chess = new Chess(start);
            chess.bfs(start, index);
        }
    }

    /**
     * Call the print method of the ChessTree class and print the tree.
     */
    public void print() {
        tree.printTree(tree.getRoot());
    }

    /**
     * Try to find the target board in the tree with the depth limit.
     * @param start The start board.
     * @param target The target board.
     * @param depth The depth limit.
     */
    public void dfs(String start, String target, int depth) {
        Long startTime = System.currentTimeMillis();
        TreeNode node = tree.dfs(tree.getRoot(), target, depth);
        Long duration = System.currentTimeMillis() - startTime;
        dfsStats(start, target, node, duration);
    }

    /**
     * Find a win board in the tree with the breadth first search.
     * @param start The start board.
     * @param search The search choice.
     */
    public void bfs(String start, int search) {
        QueueNode node;
        Long startTime = System.currentTimeMillis();
        if (search == 3) {
            node = queue.bfs(queue.getFront(), ChessFaker.getFitness(start));
        }
        else {
            node = queue.bfsRec(queue.getFront(), ChessFaker.getFitness(start));
        }
        Long duration = System.currentTimeMillis() - startTime;
        bfsStats(start, node, duration);
    }

    /**
     * Print the statistics of the dfs algorithm.
     * @param start The start board.
     * @param target The target board.
     * @param node The node that contains the result board.
     * @param duration The duration of the search.
     */
    public void dfsStats(String start, String target, TreeNode node, Long duration) {
        System.out.println("Search from " + start + " to " + target);
        if (node == null) {
            System.out.println("Moves to target: Cannot move to target");
            System.out.println("Target fitness: Unknown");
        }
        else {
            System.out.print("Moves to target: ");
            if (node.getMoves().length == 0) {
                System.out.println();
            }
            else {
                for (int i = 0; i < node.getMoves().length; i++) {
                    if (i != node.getMoves().length - 1) {
                        System.out.print(node.getMoves()[i] + " + ");
                    }
                    else {
                        System.out.println(node.getMoves()[i]);
                    }
                }
            }
            System.out.println("Target fitness: " + ChessFaker.getFitness(target));
        }
        System.out.println("Nodes Visited: " + tree.getVisited());
        System.out.println("Duration: " + duration);
    }

    /**
     * Print the statistics of the bfs algorithm.
     * @param start The start board.
     * @param node The node that contains the result board.
     * @param duration The duration of the search.
     */
    public void bfsStats(String start, QueueNode node, Long duration) {
        System.out.println("Playing to win from: " + start);
        System.out.println("Starting fitness: " + ChessFaker.getFitness(start));
        System.out.print("Moves to target: ");
        for (int i = 0; i < node.getMoves().length; i++) {
            if (i != node.getMoves().length - 1) {
                System.out.print(node.getMoves()[i] + " + ");
            }
            else {
                System.out.println(node.getMoves()[i]);
            }
        }
        System.out.println("Win state: " + node.getEntry());
        System.out.println("Target fitness: " + ChessFaker.getFitness(node.getEntry()));
        System.out.println("Nodes Visited: " + queue.getVisited());
        System.out.println("Duration: " + duration);
    }
}
