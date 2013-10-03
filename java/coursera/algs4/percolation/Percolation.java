/****************************************************************************
 *  Name: Hideki Itakura
 *  Email: h.itakura@yahoo.com
 *  Date:  08/16/2012
 *  Purpose: Percolation
 *
 ****************************************************************************/
public class Percolation {
    private boolean[] grid = null;
    private boolean[] full = null;
    private int N = 0;
    private WeightedQuickUnionUF uf = null;
    private boolean percolate = false;
    private boolean lastFull = false;


    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        this.lastFull = false;
        this.percolate = false;
        this.N = N;
        this.grid = new boolean[N * N];
        this.full = new boolean[N * N];
        this.uf = new WeightedQuickUnionUF(N * N);
    }

    // open site (row i, column j) if it is not already
    public void open(int i, int j) {
        if (i <= 0 || i > N) 
            throw new IndexOutOfBoundsException("row index i out of bounds");
        if (j <= 0 || j > N) 
            throw new IndexOutOfBoundsException("row index j out of bounds");
 
        lastFull = false;
        
        int pos = pos(i, j);
        grid[pos] = true;
        
        boolean f = false;
        if (i == 1) {
            full[pos] = true;
            f = true;
        }

        // up
        if (i > 1 && isOpen(i - 1, j)) {
            if (f || isFull(i-1, j))
                f = true;
            int upPos = N * (i - 2) + (j - 1);
            uf.union(upPos, pos);

        }

        // down
        if (i < N && isOpen(i + 1, j)) {
            if (f || isFull(i+1, j))
                f = true;
            int downPos = N * (i - 0) + (j - 1);
            uf.union(downPos, pos);
        }

        // left
        if (j > 1 && isOpen(i, j - 1)) {
            if (f || isFull(i, j-1))
                f = true;
            int leftPos = N * (i - 1) + (j - 2);
            uf.union(leftPos, pos);
        }

        // right
        if (j < N && isOpen(i, j + 1)) {
            if (f || isFull(i, j+1))
                f = true;
            int rightPos = N * (i - 1) + (j + 0);
            uf.union(rightPos, pos);
        }
        
        if (f) {
            setFull(pos);
            lastFull = true;
        }
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        if (i <= 0 || i > N) 
            throw new IndexOutOfBoundsException("row index i out of bounds");
        if (j <= 0 || j > N) 
            throw new IndexOutOfBoundsException("row index j out of bounds");

        int pos = pos(i, j);
        return grid[pos];
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        if (i <= 0 || i > N) 
            throw new IndexOutOfBoundsException("row index i out of bounds");
        if (j <= 0 || j > N) 
            throw new IndexOutOfBoundsException("row index j out of bounds");
        
        if (!isOpen(i, j)) return false;
        
        int pos = pos(i, j);
        if (full[pos]) return true;
        return full[uf.find(pos)];
    }

    private void setFull(int pos) {
        full[uf.find(pos)] = true;
        full[pos] = true;
    }

    // does the system percolate?
    public boolean percolates() {       
        if (!percolate) {
            if (lastFull) {
                for (int k = 1; k <= N; k++) {
                    if (isOpen(N, k)) {
                        if (isFull(N, k)) {
                            percolate = true;
                        }
                    }
                }
            }
        }
        return percolate;
    }
    
    private int pos(int i, int j) {
        return N * (i - 1) + (j - 1);
    }
}