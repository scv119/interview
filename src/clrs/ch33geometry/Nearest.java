import java.util.*;

public class Nearest {
    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public double solve(final List<Point> points) {
        assert(points.size() >= 2);

        List<Integer> xList = new ArrayList<Integer>();
        List<Integer> yList = new ArrayList<Integer>();

        for (int i = 0; i < points.size(); i ++) {
            xList.add(i); yList.add(i);
        }

        Collections.sort(xList, new Comparator<Integer>(){
            @Override
            public int compare(Integer x1, Integer x2) {
                return points.get(x1).x - points.get(x2).x;
            }
        });
        
        Collections.sort(yList, new Comparator<Integer>(){
            @Override
            public int compare(Integer y1, Integer y2) {
                return points.get(y1).y - points.get(y2).y;
            }
        });

        return solve(points, xList, yList);
    }

    private double solve(List<Point> points, List<Integer> xList, List<Integer> yList) {
        double ret = Double.MAX_VALUE;

        if (xList.size() <= 3) {
            for (int i = 0; i < xList.size() - 1; i ++) {
                for (int j = i + 1; j < xList.size(); j ++) {
                   ret = Math.min(distance(points.get(xList.get(i)), points.get(xList.get(j))), ret); 
                }
            }
            return ret;
        }

        int mid = xList.size() / 2; 
        boolean[] left = new boolean[points.size()];
        Arrays.fill(left, false);
        List<Integer> xLeftList = new ArrayList<Integer>();
        List<Integer> xRightList = new ArrayList<Integer>();
        List<Integer> yLeftList = new ArrayList<Integer>();
        List<Integer> yRightList = new ArrayList<Integer>();

        for (int i = 0; i < mid; i ++) {
            xLeftList.add(xList.get(i));
            left[xList.get(i)] = true;
        }
        
        for (int i = mid; i < xList.size(); i ++) {
            xRightList.add(xList.get(i));
        }

        for (int i = 0; i < yList.size(); i ++) {
            if (left[yList.get(i)])
                yLeftList.add(yList.get(i));
            else
                yRightList.add(yList.get(i));
        }
        
        ret = Math.min(solve(points, xLeftList, yLeftList), solve(points, xRightList, yRightList));
        Arrays.fill(left, false);
        left[xList.get(mid)] = true;
        int xmid = points.get(xList.get(mid)).x;
        int start = mid - 1;
        while (start >= 0 && xmid - points.get(xList.get(start)).x < ret) {
            left[xList.get(start)] = true;
            start --;
        }
        int end   = mid + 1;
        while (end < xList.size() && points.get(xList.get(end)).x - xmid < ret) {
            left[xList.get(end)] = true;
            end ++; 
        }

        List<Integer> yMerge = new ArrayList<Integer>();

        for (int i : yList) {
            if (left[i]) 
                yMerge.add(i);
        }

        for (int i = 0; i < yMerge.size(); i ++) {
            for (int j = i + 1; j < yMerge.size() && j <= i + 7; j ++) {
                ret = Math.min(ret, distance(points.get(yMerge.get(i)), points.get(yMerge.get(j))));
            }
        }
        
        return ret;
    }

    double distance(Point p1, Point p2) {
        return Math.sqrt(1l * (p1.x - p2.x) * (p1.x - p2.x) + 1l * (p1.y - p2.y) * (p1.y - p2.y));
    }

    public double solve1(List<Point> points) {
        double ret = Double.MAX_VALUE;
        for (Point point : points) 
            for (Point point1 : points) 
                if (point != point1)
                    ret = Math.min(ret, distance(point, point1));
        return ret;
    }

    public static void main(String args[]) {
        Nearest nr = new Nearest();
        List<Point> points = new ArrayList<Point>();

        for(int i = 0; i < 30000; i ++) {
            points.add(new Point((int)(Math.random() * 1000000), (int)(Math.random() * 1000000)));
        }
        Date date1 = new Date();
        System.out.println(nr.solve(points));
        Date date2 = new Date();
        System.out.println(date2.getTime() - date1.getTime());
        System.out.println(nr.solve1(points));
        Date date3 = new Date();
        System.out.println(date3.getTime() - date2.getTime());
    }
}
