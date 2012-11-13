package clrs.ch33geometry;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 11/13/12
 * Time: 3:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Segment {
    int x1; int y1;
    int x2; int y2;

    public Segment() {};

    public Segment(int x2, int y2) {
        this.x2 = x2;
        this.y2 = y2;
    }

    public Segment(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public Object clone() {
        Segment seg = new Segment();
        seg.x1 = x1;
        seg.x2 = x2;
        seg.y1 = y1;
        seg.y2 = y2;

        return seg;
    }


    public Segment toVector() {
        if (x1 == 0 && y1 == 0)
            return (Segment)this.clone();

        return new Segment(0, 0, x2 - x1, y2 - y1);
    }

    public double length() {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public static int dotProduct(Segment s1, Segment s2) {
        s1 = s1.toVector();
        s2 = s2.toVector();

        return s1.x2 * s2.x2 + s1.y2 * s2.y2;
    }

    public static int crossProduct(Segment s1, Segment s2) {
        s1 = s1.toVector();
        s2 = s2.toVector();

        return s1.x2 * s2.y2 - s2.x2 * s1.y2;
    }

    public static boolean intersect(Segment s1, Segment s2) {
        int d1 = crossProduct(s1, new Segment(s1.x1, s1.y1, s2.x1, s2.y1));
        int d2 = crossProduct(s1, new Segment(s1.x1, s1.y1, s2.x2, s2.y2));
        int d3 = crossProduct(s2, new Segment(s2.x1, s2.y1, s1.x1, s1.y1));
        int d4 = crossProduct(s2, new Segment(s2.x1, s2.y1, s1.x2, s1.y2));


        if (d1 * d2 < 0 && d3 * d4 < 0)
            return true;

        if (d1 == 0 && onSegment(s1, s2.x1, s2.y1))
            return true;
        if (d2 == 0 && onSegment(s1, s2.x2, s2.y2))
            return true;
        if (d3 == 0 && onSegment(s2, s1.x1, s1.y1))
            return true;
        if (d4 == 0 && onSegment(s2, s1.y2, s1.y2))
            return true;

        return false;
    }

    private static boolean onSegment(Segment s, int x, int y) {
        if (Math.min(s.x1, s.x2) <= x && Math.max(s.x1, s.x2) >= x && Math.min(s.y1, s.y2) <= y && y <= Math.max(s.y1, s.y2))
            return true;
        return false;
    }

    public static void main (String arg[]) {
//        assert (false);
        assert (!intersect(new Segment(0, 0, -1, -1), new Segment(0, 1, 1, 0)));
    }

}
