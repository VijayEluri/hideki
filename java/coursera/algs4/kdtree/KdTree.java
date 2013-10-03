import java.util.ArrayList;
import java.util.List;

public class KdTree {

    private static class Node {

        // the point
        private Point2D p = null;
        // the axis-aligned rectangle corresponding to this node
        private RectHV rect = null;
        // the left/bottom subtree
        private Node lb = null;
        // the right/top subtree
        private Node rt = null;

        private Node(Point2D p, RectHV rect) {
            this.p = p;
            this.rect = rect;
            this.lb = null;
            this.rt = null;
        }

        @Override
        public String toString() {
            return "Node [p=" + p + ", rect=" + rect + "]";
        }

    }

    private Node root = null;
    private int size = 0;

    // for nearest neighbor
    private Point2D nearest = null;
    private double distanceToNearest = Double.POSITIVE_INFINITY;

    // construct an empty set of points
    public KdTree() {
        root = null;
        size = 0;
    }

    // is the set empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // number of points in the set
    public int size() {
        return size;
    }

    // add the point p to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (root == null) {
            root = new Node(p, new RectHV(0f, 0f, 1f, 1f));
            size++;
            return;
        }
        insert(root, p, 0);
    }

    private void insert(Node node, Point2D p, int depth) {
        if (node == null)
            return;

        if (node.p.equals(p))
            return;

        boolean xCoordinate = depth % 2 == 0;
        if (xCoordinate) {
            if (p.x() < node.p.x()) {
                if (node.lb == null) {
                    node.lb = new Node(p, new RectHV(node.rect.xmin(),
                            node.rect.ymin(), node.p.x(), node.rect.ymax()));
                    size++;
                } else {
                    insert(node.lb, p, depth + 1);
                }
            } else {
                if (node.rt == null) {
                    node.rt = new Node(p, new RectHV(node.p.x(),
                            node.rect.ymin(), node.rect.xmax(),
                            node.rect.ymax()));
                    size++;
                } else {
                    insert(node.rt, p, depth + 1);
                }
            }
        } else {
            if (p.y() < node.p.y()) {
                if (node.lb == null) {
                    node.lb = new Node(p, new RectHV(node.rect.xmin(),
                            node.rect.ymin(), node.rect.xmax(), node.p.y()));
                    size++;
                } else {
                    insert(node.lb, p, depth + 1);
                }
            } else {
                if (node.rt == null) {
                    node.rt = new Node(p, new RectHV(node.rect.xmin(),
                            node.p.y(), node.rect.xmax(), node.rect.ymax()));
                    size++;
                } else {
                    insert(node.rt, p, depth + 1);
                }
            }
        }
    }

    // does the set contain the point p?
    public boolean contains(Point2D p) {
        return contains(root, p, 0);
    }

    private boolean contains(Node node, Point2D p, int depth) {
        if (node == null)
            return false;

        if (node.p.equals(p))
            return true;

        boolean xCoordinate = depth % 2 == 0;
        if ((xCoordinate && p.x() < node.p.x())
                || (!xCoordinate && p.y() < node.p.y())) {
            return contains(node.lb, p, depth + 1);
        } else {
            return contains(node.rt, p, depth + 1);
        }
    }

    // draw all of the points to standard draw
    public void draw() {
        draw(root, 0);
    }

    private void draw(Node node, int depth) {
        if (node == null)
            return;

        StdDraw.setPenRadius(.01);
        StdDraw.setPenColor(StdDraw.BLACK);
        node.p.draw();
        StdDraw.setPenRadius();
        if (depth % 2 == 0) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.line(node.p.x(), node.rect.ymin(), node.p.x(),
                    node.rect.ymax());
            draw(node.lb, depth + 1);
            draw(node.rt, depth + 1);
        } else {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.line(node.rect.xmin(), node.p.y(), node.rect.xmax(),
                    node.p.y());
            draw(node.lb, depth + 1);
            draw(node.rt, depth + 1);
        }
    }

    // all points in the set that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        List<Point2D> list = new ArrayList<Point2D>();
        range(rect, root, list);
        return list;
    }

    private void range(RectHV rect, Node node, List<Point2D> list) {
        if (node == null)
            return;

        if (rect.contains(node.p))
            list.add(node.p);

        if (rect.intersects(node.rect)) {
            range(rect, node.lb, list);
            range(rect, node.rt, list);
        }
    }

    // a nearest neighbor in the set to p; null if set is empty
    public Point2D nearest(Point2D p) {
        if (p == null)
            return null;
        nearest = root.p;
        distanceToNearest = root.p.distanceSquaredTo(p);
        nearest(p, root, 0);
        return nearest;
    }

    private void nearest(Point2D p, Node node, int depth) {
        if (node == null)
            return;

        // if the closest point discovered so far is closer than the distance
        // between the query point and the rectangle corresponding to a node,
        // there is no need to explore that node (or its subtrees).
        if (node.rect.distanceSquaredTo(p) < distanceToNearest) {
            double distance = node.p.distanceSquaredTo(p);
            if (distance < distanceToNearest) {
                nearest = node.p;
                distanceToNearest = distance;
            }

            // The effectiveness of the pruning rule depends on quickly finding
            // a nearby point. To do this, organize your recursive method so
            // that when there are two possible subtrees to go down, you always
            // choose the subtree that is on the same side of the splitting line
            // as the query point as the first subtree to explore the closest
            // point found while exploring the first subtree may enable pruning
            // of the second subtree.
            boolean xCoordinate = depth % 2 == 0;
            if ((xCoordinate && p.x() < node.p.x())
                    || (!xCoordinate && p.y() < node.p.y())) {
                nearest(p, node.lb, depth + 1);
                nearest(p, node.rt, depth + 1);
            } else {
                nearest(p, node.rt, depth + 1);
                nearest(p, node.lb, depth + 1);
            }
        }
    }
}