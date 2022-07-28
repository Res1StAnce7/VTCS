public class Chess {
    private ChessTree tree;
    private ChessQueue queue;

    public static void main(String[] args) throws Exception {
        runTask(3, 3, "ViennaOpen");
    }

    public Chess(int depth, String start) {
        this.tree = new ChessTree(start);
        this.tree.buildTree(depth, tree.getRoot()); 
    }

    public Chess(String start) {
        this.queue = new ChessQueue("ViennaOpen");
    }

    public static void runTask(int index, int depth, String start) {
        if (index == 1 || index == 2) {
            Chess chess = new Chess(depth, start);
            if (index == 1) {
                chess.print();
            }
            else {
                chess.dfs(start, "HJenWpoSen", depth);
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
        int result[] = tree.dfs(tree.getRoot(), target, depth, 0);
        Long duration = System.currentTimeMillis() - startTime;
        dfsStats(start, target, result, duration);
    }

    public void dfsStats(String start, String target, int[] result, Long duration) {
        System.out.println("Search from " + start + " to " + target);
        System.out.println("Moves to target: " + result[1]);
        if (result[0] == -1) {
            System.out.println("Target fitness: Unknown");
        }
        else {
            System.out.println("Target fitness: " + ChessFaker.getFitness(target));
        }
        System.out.println("Nodes visited: " + tree.getVisited());
        System.out.println("Durantion: " + duration);
    }

    public void bfs(String start) {
        Long startTime = System.currentTimeMillis();
        String[] result = queue.bfs(queue.getFront(), start, 0);
        Long duration = System.currentTimeMillis() - startTime;
        bfsStats(start, result, duration);
    }

    public void bfsStats(String start, String[] result, Long duration) {
        System.out.println("Playing to win from: " + start);
        System.out.println("Starting fitness: " + ChessFaker.getFitness(start));
        System.out.println("Moves to target: " + result[0]);
        System.out.println("Win state: " + result[1]);
        System.out.println("Target fitness: " + ChessFaker.getFitness(result[1]));
        System.out.println("Nodes visited: " + queue.getVisited());
        System.out.println("Durantion: " + duration);
    }
}
