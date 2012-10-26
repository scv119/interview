package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-26
 * Time: PM8:52
 * To change this template use File | Settings | File Templates.
 */

//TODO write it again!
public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if(num == null || num.length < 3)
            return result;

        Arrays.sort(num);

        for(int i = 0; i < num.length - 2; i ++) {
            if(i != 0 && num[i] == num[i-1])
                continue;

            if(num[i] > 0)
                break;

            int start = i + 1;
            int end   = num.length - 1;
            int value = 0 - num[i];


            while(start < end) {
                if(num[start] > value)
                    break;

                if(num[start] + num[end] == value) {
                    ArrayList<Integer> ret = new ArrayList<Integer>();
                    ret.add(num[i]);
                    ret.add(num[start]);
                    ret.add(num[end]);
                    result.add(ret);
                    int pos = start;
                    while(num[pos] == num[start] && start < end)
                        start ++;
                } else if(num[start] + num[end] < value) {
                    start ++;
                } else {
                    end   --;
                }
            }

        }

        return result;
    }

    public static void main(String args[]) {
        ThreeSum ts = new ThreeSum();
        ts.threeSum(new int[]{-4, 1, 3, 2, 2});
    }
}
