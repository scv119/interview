package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-28
 * Time: PM2:59
 * To change this template use File | Settings | File Templates.
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0)
            return 0;

        int len = height.length;
        int left[] = new int[len];
        int right[] = new int[len];

        List<int[]> stack = new ArrayList<int[]>();

        for(int i = 0; i < len; i ++) {
            int h = height[i];

            while(stack.size() > 0) {
                if(stack.get(stack.size() - 1)[1] < h)
                    break;
                stack.remove(stack.size() - 1);
            }

            if( stack.size() == 0)
                left[i] = 0;
            else
                left[i] = stack.get(stack.size() - 1)[0] + 1;
            stack.add(new int[]{i, h});
        }

        stack.clear();
        for(int i = len - 1; i >= 0; i --) {
            int h = height[i];

            while(stack.size() > 0) {
                if(stack.get(stack.size() - 1)[1] < h)
                    break;
                stack.remove(stack.size() - 1);
            }

            if( stack.size() == 0)
                right[i] = len - 1;
            else
                right[i] = stack.get(stack.size() - 1)[0] - 1;
            stack.add(new int[]{i, h});
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < len; i ++) {
            max = Math.max(height[i] * (right[i] - left[i] + 1), max);
        }
        return max;
    }
}
