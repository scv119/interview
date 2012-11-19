import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-15
 * Time: PM8:02
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public int findFirstMissing(int[] arr) {
        assert(arr != null);
        int len = arr.length;

        if (len == 0)
            return 1;
        // [2,3]
        for (int i = 0; i < arr.length; i ++) {
            int idx = arr[i] - 1;
            if (idx < arr.length)
                arr[idx] = -1 * Math.abs(arr[idx]);
        }
        // [2, -3]

        int ret = -1;
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] > 0) {
                ret = i + 1;
                break;
            }
        }
        // ret = 1

        if (ret == -1)
            ret = arr.length + 1;
        return ret;
    }
    public static void main(String args[]) {
        Test solution = new Test();
        System.out.println(solution.findFirstMissing(new int[]{2, 3}));
    }
}
