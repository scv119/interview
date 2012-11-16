package clrs.ch33geometry;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 */
public class Graham {
    public static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return x + " " + y;
        }
    }

    int crossProduct(Point p1, Point p2, Point p3) {
        return (p2.x - p1.x) * (p3.y - p1.y) - (p3.x - p1.x) * (p2.y - p1.y);
    }

    
    public List<Point> solve(List<Point> list) {
        Point p0 = null;
        int minY = Integer.MAX_VALUE;
        for (Point p : list) {
            minY = Math.min(minY, p.y);
            if (minY == p.y)
                p0 = p;
        }
        final Point start = p0;
        list.remove(p0);
        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return crossProduct(start, p2, p1);
            }
        });

        Stack<Point> stack = new Stack<Point>();
        stack.push(p0);
        stack.push(list.get(0));
        stack.push(list.get(1));

        for (int i = 2; i < list.size(); i ++) {
            Point next = list.get(i);
            while (true) {
                Point top  = stack.peek();
                Point pre  = stack.get(stack.size() - 2);
                if (crossProduct(top, pre, next) > 0)
                    stack.pop();
                else
                    break;
            }
            stack.push(next);
        }

        List<Point> ret = new ArrayList<Point>();
        ret.addAll(stack);
        return ret;
    }

    public static void main(String args[]) {
        Graham g = new Graham();
        List<Point> list = new ArrayList<Point>();
        list.add(new Point(0, 0));
        list.add(new Point(1, 1));
        list.add(new Point(2,2));
        list.add(new Point(1, 0));
        list.add(new Point(0, 1));
        list = g.solve(list);
        for (Point point : list) {
            System.out.println(point.toString());
        }
    }

}
