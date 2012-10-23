package facebook;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-23
 * Time: PM10:23
 * To change this template use File | Settings | File Templates.
 */
public class FindFirstOne {
    static int xx;
    public static void init(int x) {
        xx = x;
    }
    //given funciton
    public static int get(int idx) {
        if(idx < xx)
            return 0;
        return 1;
    }

    public static int solve() {
        if(get(0) == 1)
            return 0;
        int start = 0;
        int end  = 2;
        while(get(end) == 0) {
            start = end;
            end = end * 2;
        }

        while(start < end - 1) {
            int mid = (start + end) / 2;
            if(get(mid) == 0)
                start = mid;
            else
                end = mid;
        }

        return end;
    }

    public static void main(String args[]) {
        for(int i = 10 ; i < Integer.MAX_VALUE/3 ; i ++) {
            init(i);
            assert (solve() == i);
        }
    }
}