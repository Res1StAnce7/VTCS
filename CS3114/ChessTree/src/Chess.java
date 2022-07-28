public class Chess {
    private ChessTree tree;
    private ChessQueue queue;

    public static void main(String[] args) throws Exception {
        runTask(3, 3, "ViennaOpeln");
    }

    public Chess(int depth, String start) {
        this.tree = new ChessTree(start);
        this.tree.buildTree(depth, tree.getRoot()); 
    }

    public Chess(String start) {
        this.queue = new ChessQueue(start);
    }

    public static void runTask(int index, int depth, String start) {
        if (index == 1 || index == 2) {
            Chess chess = new Chess(depth, start);
            if (index == 1) {
                chess.print();
            }
            else {
                chess.dfs(start, "VienngOSen", depth);
            }
        }
        else {
            Chess chess = new Chess(start);
            chess.bfs(start);
        }
    }

    public void print() {
        tree.printTree(tree.getRoot());
    }

    public void dfs(String start, String target, int depth) {
        Long startTime = System.currentTimeMillis();
        TreeNode node = tree.dfs(tree.getRoot(), target, depth);
        Long duration = System.currentTimeMillis() - startTime;
        dfsStats(start, target, node, duration);
    }

    public void dfsStats(String start, String target, TreeNode node, Long duration) {
        System.out.println("Search from " + start + " to " + target);
        if (node == null) {
            System.out.println("Moves to target: Cannot move to target");
            System.out.println("Target fitness: Unknown");
        }
        else {
            System.out.print("Moves to target: ");
            for (int i = 0; i < node.getMoves().length; i++) {
                if (i != node.getMoves().length - 1) {
                    System.out.print(node.getMoves()[i] + " + ");
                }
                else {
                    System.out.println(node.getMoves()[i]);
                }
            }
            System.out.println("Target fitness: " + ChessFaker.getFitness(target));
        }
        System.out.println("Nodes visited: " + tree.getVisited());
        System.out.println("Durantion: " + duration);
    }

    public void bfs(String start) {
        Long startTime = System.currentTimeMillis();
        QueueNode node = queue.bfs(queue.getFront(), start);
        Long duration = System.currentTimeMillis() - startTime;
        bfsStats(start, node, duration);
    }

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
        System.out.println("Nodes visited: " + queue.getVisited());
        System.out.println("Durantion: " + duration);
    }
}
