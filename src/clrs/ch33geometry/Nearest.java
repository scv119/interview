public class Nearest {
    public class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public double solve(List<Point> points) {
        Collections.sort(points, new Comparator<Point>(){
            @Override
            public int compare(Point p0, Point p1) {
                int ret = p0.x - p1.x;
                if (ret != 0)
                    return ret;
                return p0.y - p1.y;
            }
        });     

        assert(points.size() >= 2);

        return solve(points, 0, points.size() - 1);
    }

    private double solve(List<Point> points, int start, int len) {
        if (len <= 3 || points.get(start).x == points.get(start + len - 1).x) {
            double ret = Double.MAX_VALUE;
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j ++) {
                    ret = Math.min(ret, distance(points.get(i + start), points.get(j + start))); 
                }
            }
            return ret;
        }

        int mid = (len + 1) / 2; 
        int left = mid;
        int right = mid;
        int x = points.get(start + mid).x;

        while (left != 0 && points.get(start + left - 1).x == x)
            left --;

        while (right != len - 1 && points.get(start + right + 1).x == x)
            right ++;

    }

    double distance(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }
}
