package clrs.ch33geometry;

import java.util.*;

public class Geo {
    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int crossProduct(Point p0, Point p1, Point p2, Point p3) {
        return (p1.x - p0.x) * (p3.y - p2.y) - (p3.x - p2.x) * (p1.y - p0.y);
    }

    public boolean segmentCross(Point p0, Point p1, Point p2, Point p3) {
        int d0 = crossProduct(p0, p1, p0, p2);
        int d1 = crossProduct(p0, p1, p0, p3);
        int d2 = crossProduct(p2, p3, p2, p0);
        int d3 = crossProduct(p2, p3, p2, p1);

        if (d0 * d1 < 0 && d2 * d3 < 0)
            return true;
        if (d0 == 0 && onSegment(p2, p0, p1))
            return true;
        if (d1 == 0 && onSegment(p3, p0, p1))
            return true;
        if (d2 == 0 && onSegment(p0, p2, p3))
            return true;
        if (d3 == 0 && onSegment(p1, p2, p3))
            return true;
        
        return false;
    }

    private boolean onSegment(Point p0, Point p1, Point p2) {
        if (p0.x >= Math.min(p1.x, p2.x) && p0.x <= Math.max(p1.x, p2.x)
            && p0.y >= Math.min(p1.y, p2.y) && p0.y <= Math.max(p1.y, p2.y))
            return true;
        return false;
    }


    public List<Point> graham(List<Point> list) {
        assert(list.size() > 3);
        int minY = Integer.MAX_VALUE;
        Point pole = null;

        for (Point p : list) {
            if (pole == null || minY > p.y) {
                pole = p;
                minY = pole.y; 
            }
        }

        list.remove(pole);
        final Point pt = pole; 

        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point p0, Point p1) {
                return crossProduct(pt, p0, pt, p1) * -1;
            }
        });

        Stack<Point> stack = new Stack<Point>();
        stack.push(pole);
        stack.push(list.get(0));
        stack.push(list.get(1));

        for (int i = 2; i < list.size(); i ++) {
           Point point = list.get(i); 
           Point cur   = stack.peek();
           Point pre   = stack.get(stack.size() - 2);

           while (true) {
                if (crossProduct(cur, pre, cur, point) <= 0)
                    break;
                cur = pre;
                stack.pop();
                pre = stack.get(stack.size() - 2);
           }

            stack.push(point);
        }

        List<Point> ret = new ArrayList<Point>();

        ret.addAll(stack);

        return ret;
    }

    private int _x;
}
