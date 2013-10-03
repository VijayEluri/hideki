/****************************************************************************
 *  Name: Hideki Itakura
 *  Email: h.itakura@yahoo.com
 *  Date:  08/16/2012
 *  Purpose: PercolationStats
 *
 ****************************************************************************/
public class PercolationStats {
    private int N;
    private int T;
    private double[] results;

    // perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        if (N <= 0) throw new IllegalArgumentException("N should be larger than 0");
        if (T <= 0) throw new IllegalArgumentException("T should be larger than 0");
        
        this.N = N;
        this.T = T;

        results = new double[T];
        for (int i = 0; i < T; i++) {
            results[i] = (double) simulate() / (N * N);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        if (T == 1)
            return Double.NaN;
        return StdStats.stddev(results);
    }

    // sample 95% confidence interval of percolation threshold
    private double ci95() {
        return 1.96 * stddev() / Math.sqrt((double) T);
    }
    
    // do experiment
    private int simulate() {
        Percolation percolation = new Percolation(N);
        for (int k = 0;; k++) {
            if (percolation.percolates()) return k;
            
            int i, j;
            do {
                i = StdRandom.uniform(1, N+1);
                j = StdRandom.uniform(1, N+1);
            } while (percolation.isOpen(i, j));
            
            percolation.open(i, j);
        }
    }

    // test client, described below
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java PercolationStats <N> <T>");
            return;
        }

        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);

        PercolationStats percolationStats = new PercolationStats(N, T);

        double mean   = percolationStats.mean();
        double stddev = percolationStats.stddev();
        double ci     = percolationStats.ci95();

        StdOut.println("mean                    = " + mean);
        StdOut.println("stddev                  = " + stddev);
        StdOut.println("95% confidence interval = " + (mean - ci) + ", "
                + (mean + ci));
    }
}
