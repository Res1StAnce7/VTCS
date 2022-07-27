public class Chess {
    private ChessTree tree;

    public Chess(int depth) {
        this.tree = new ChessTree("ViennaOpen");
        tree.buildTree(depth, tree.getRoot());
    }
    public static void main(String[] args) throws Exception {
        runTask(1, 3);
    }

    public static void runTask(int index, int depth) {
        Chess chess = new Chess(depth);

        if (index == 1) {
            chess.print();
        }
        else if (index == 2) {
            chess.dfs("ViennaOpen", "VJenWgoYen", depth);
        }
    }
    public void print() {
        tree.printTree(tree.getRoot());
    }

    public void dfs(String start, String target, int depth) {
        Long startTime = System.currentTimeMillis();
        int result[] = tree.dfs(tree.getRoot(), target, depth, 0);
        Long duration = System.currentTimeMillis() - startTime;
        printStats(start, target, result, duration);
    }

    public void printStats(String start, String target, int[] result, Long duration) {
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
}
