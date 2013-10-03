import java.util.Comparator;

public class Solver {

    private class SearchNode {
        private Board board;
        private SearchNode prev;
        private int moves;

        public SearchNode(Board board, SearchNode prev, int moves) {
            this.board = board;
            this.prev = prev;
            this.moves = moves;
        }

        int cost() {
            return moves + board.manhattan();
        }
    }

    private SearchNode solutionLastNode = null;

    private class SearchNodeComparator implements Comparator<SearchNode> {
        public int compare(SearchNode o1, SearchNode o2) {
            return o1.cost() - o2.cost();
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        // previously visited board
        // List<Board> previous1 = new ArrayList<Board>();
        // List<Board> previous2 = new ArrayList<Board>();

        // priority queue
        MinPQ<SearchNode> priorityQueue1 = new MinPQ<SearchNode>(
                new SearchNodeComparator());
        MinPQ<SearchNode> priorityQueue2 = new MinPQ<SearchNode>(
                new SearchNodeComparator());

        // insert initial search node into priority queue
        priorityQueue1.insert(new SearchNode(initial, null, 0));
        priorityQueue2.insert(new SearchNode(initial.twin(), null, 0));

        while (!priorityQueue1.isEmpty()) {
            // regular
            SearchNode searchNode1 = priorityQueue1.delMin();
            // previous1.add(searchNode1.board);
            if (searchNode1.board.isGoal()) {
                solutionLastNode = searchNode1;
                break;
            }
            for (Board neighbor1 : searchNode1.board.neighbors()) {
                if (searchNode1.prev == null
                        || !neighbor1.equals(searchNode1.prev.board)) {
                    // if (!previous1.contains(neighbor1)) {
                    priorityQueue1.insert(new SearchNode(neighbor1,
                            searchNode1, searchNode1.moves + 1));
                }
            }

            // for twin
            SearchNode searchNode2 = priorityQueue2.delMin();
            // previous2.add(searchNode2.board);
            if (searchNode2.board.isGoal()) {
                solutionLastNode = null;
                break;
            }
            for (Board neighbor2 : searchNode2.board.neighbors()) {
                if (searchNode1.prev == null
                        || !neighbor2.equals(searchNode2.prev.board)) {
                    // if (!previous2.contains(neighbor2)) {
                    priorityQueue2.insert(new SearchNode(neighbor2,
                            searchNode2, searchNode2.moves + 1));
                }
            }
        }
    }

    // is the initial board solvable?
    public boolean isSolvable() {
        return solutionLastNode != null;
    }

    // min number of moves to solve initial board; -1 if no solution
    public int moves() {
        if (solutionLastNode == null)
            return -1;

        return solutionLastNode.moves;
    }

    // sequence of boards in a shortest solution; null if no solution
    public Iterable<Board> solution() {
        if (solutionLastNode == null)
            return null;

        Stack<Board> stack = new Stack<Board>();
        for (SearchNode n = solutionLastNode; n != null; n = n.prev) {
            stack.push(n.board);
        }
        return stack;
    }

    // solve a slider puzzle (given below)
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int N = in.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}