package leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-28
 * Time: PM2:40
 * To change this template use File | Settings | File Templates.
 */
public class JumpGame2 {
    public int jump(int[] A) {
        int step[] = new int[A.length];
        int start = 0;
        int max   = 0;
        int len   = A.length;

        Arrays.fill(step, Integer.MAX_VALUE);

        step[0] = 0;

        for(int i = 0; i < len; i ++) {
            if(A[i] == 0)
                continue;
            int s = Math.max(max + 1, i + 1);
            int e = Math.min(len - 1, i + A[i]);
            max   = Math.max(e, max);
            for(int j = s; j <= e; j ++) {
                step[j] = step[i] + 1;
            }
        }
        return step[len - 1];

    }
}
