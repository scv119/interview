package clrs.ch33geometry;

import java.util.*;

public class Nearest {
    public double solve(List<Point> points) {
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p0, Point p1) {
                int ret = p0.x - p1.x;
                if (ret != 0)
                    return ret;
                return p0.y - p1.y;
            }
        });

        return solve(points, 0, points.size() - 1);
    }

    public double solve1(List<Point> points) {
        assert points.size() > 1;
        double ret = Double.MAX_VALUE;
        for (Point pt : points)
            for (Point p11 :points) {
                if (pt != p11)
                    ret = Math.min(ret, distance(pt, p11));
            }

        return ret;
    }


    private double solve(List<Point> points, int startId, int endId) {
        if (startId == endId)
            return Double.MAX_VALUE;

        if (startId <= endId + 2 || points.get(startId).x == points.get(endId).x) {
            double ret = Double.MAX_VALUE;
            for (int i = startId; i < endId; i ++)
                for (int j = i + 1; j <= endId; j ++) {
                    ret = Math.min(ret, distance(points.get(i), points.get(j)));
                }
            return ret;
        }

        int mid = (startId + endId)/2;       

        int left = mid;
        int right = mid;

        while (left > startId && points.get(left - 1).x == points.get(mid).x) 
            left --;

        while (right < endId && points.get(right + 1).x == points.get(mid).x)
            right ++;

        double retLeft = solve(points, startId, right);
        double retRight = solve(points, left, endId);

        double ret = Math.min(retLeft, retRight);
        double dis = ret;
        left = mid;
        right = mid;

        while (left > startId && points.get(left - 1).x >= points.get(mid).x - ret)
            left --;

        while (right < endId && points.get(right + 1).x <= points.get(mid).x + ret)
            right ++;
        

        for (int i = left; i < right; i ++)
            for (int j = i + 1; j <= right; j ++) {
                if (points.get(j).y - points.get(i).y > dis)
                    break;
                ret = Math.min(ret, distance(points.get(i), points.get(j)));
            }

        return ret;
    }

    double distance(Point p0, Point p1) {
        return Math.sqrt((p0.x - p1.x) * (p0.x - p1.x) + (p0.y - p1.y) * (p0.y - p1.y));
    }

    public static void main(String args[]) {
        Nearest nearest = new Nearest();
        for (int i = 1; i < 10; i ++) {
            List<Point> list = new ArrayList<Point>();
            for (int j = 0; j < 50000; j ++) {
                list.add(new Point((int)(Math.random() * 100000), (int)(Math.random() * 100000)));
            }
            Date d0 = new Date();
            double ret1 = nearest.solve(list);
            Date d1 = new Date();
            double ret2 = nearest.solve1(list);
            Date d2 = new Date();
            if (Math.abs(ret1 - ret2) > 0.00001f)
                System.out.println("ERROR");
            else
                System.out.println((d1.getTime() - d0.getTime()) + " " + (d2.getTime() - d1.getTime()));
        }
    }

}
