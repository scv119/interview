package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-26
 * Time: PM11:58
 * To change this template use File | Settings | File Templates.
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if(n <= 1)
            return 1;
        int arr[] = new int[3];
        int next = 1;
        arr[0] = 1; arr[1] = 1;
        for(int i = 1; i < n; i ++) {
            next = (next + 1)%3;
            arr[next] = arr[(next + 1)%3] + arr[(next + 2)%3];
        }
        return arr[next];
    }
}
