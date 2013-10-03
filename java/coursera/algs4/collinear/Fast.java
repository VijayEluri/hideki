import java.util.Arrays;

public class Fast {
    private static void printPoints(Point p, Point[] points, int lo, int hi) {
        System.out.print(p);
        for (int i = lo; i <= hi; i++) {
            System.out.print(" -> " + points[i]);
        }
        System.out.println("");
    }

    private static boolean sameline(Point a, Point b, Point c) {
        return (a.SLOPE_ORDER.compare(b, c) == 0);
            
    }

    private static boolean unique(Point[] points, int prev, Point a, Point b) {
        for (int i = 0; i < prev; i++) {
            if (sameline(a, b, points[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);

        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();

        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
            points[i].draw();
        }
        Arrays.sort(points);

        for (int i = 0; i < N - 3; i++) {

            Point p = points[i];
            Arrays.sort(points, i + 1, N, p.SLOPE_ORDER);
            int count = 1;
            double prevSlope = p.slopeTo(points[i + 1]);
            int j;
            for (j = i + 2; j < N; j++) {
                double currSlope = p.slopeTo(points[j]);
                if (currSlope == prevSlope) {
                    count++;
                } else {
                    if (count >= 3) {
                        if (unique(points, i, p, points[j - 1])) {
                            printPoints(p, points, j - count, j - 1);
                            p.drawTo(points[j - 1]);
                        }
                    }
                    count = 1;
                    prevSlope = currSlope;
                }
            }
            if (count >= 3) {
                if (unique(points, i, p, points[j - 1])) {
                    printPoints(p, points, j - count, j - 1);
                    p.drawTo(points[j - 1]);
                }
            }
            Arrays.sort(points, i + 1, N);
        }

        StdDraw.show(0);
    }
}