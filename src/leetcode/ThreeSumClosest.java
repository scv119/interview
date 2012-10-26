package leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-26
 * Time: PM9:16
 * To change this template use File | Settings | File Templates.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        int minAbs = Integer.MAX_VALUE;
        int min    = -1;
        Arrays.sort(num);


        for(int i = 0 ; i < num.length - 2; i ++) {
            int j = i + 1;
            int k = num.length - 1;

            while(j < k) {
                int value = num[i] + num[j] + num[k];
                int diff  = value - target;
                if(Math.abs(diff) < minAbs) {
                    minAbs = Math.abs(diff);
                    min    = value;
                }
                if(diff == 0)
                    break;
                else if(diff > 0) {
                    k --;
                } else {
                    j ++;
                }

            }
        }

        return min;

    }
}