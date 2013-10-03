import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class PointSET {
    private TreeSet<Point2D> points = null;

    // construct an empty set of points
    public PointSET() {
        points = new TreeSet<Point2D>();
    }

    // is the set empty?
    public boolean isEmpty() {
        return points.isEmpty();
    }

    // number of points in the set
    public int size() {
        return points.size();
    }

    // add the point p to the set (if it is not already in the set)
    public void insert(Point2D p) {
        points.add(p);
    }

    // does the set contain the point p?
    public boolean contains(Point2D p) {
        return points.contains(p);
    }

    // draw all of the points to standard draw
    public void draw() {
        // StdDraw.setPenColor(StdDraw.BLACK);
        // StdDraw.setPenRadius(.01);
        for (Point2D p : points) {
            p.draw();
        }
    }

    // all points in the set that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        List<Point2D> list = new ArrayList<Point2D>();
        for (Point2D p : points) {
            if (rect.contains(p)) {
                list.add(p);
            }
        }
        return list;
    }

    // a nearest neighbor in the set to p; null if set is empty
    public Point2D nearest(Point2D source) {
        double min = Double.POSITIVE_INFINITY;
        Point2D point = null;

        for (Point2D p : points) {
            double distance = source.distanceTo(p);
            if (distance < min) {
                point = p;
                min = distance;
            }
        }

        return point;
    }
}
