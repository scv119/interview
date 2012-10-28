package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-28
 * Time: PM2:16
 * To change this template use File | Settings | File Templates.
 */
public class CanJump {
    public boolean canJump(int[] A) {
        int start = 0;
        int max   = 0;
        int dest  = A.length - 1;

        while(start <= max && start <= dest) {
            max = Math.max(max, A[start] + start);
            start ++;
        }

        return max >= dest;

    }
}
