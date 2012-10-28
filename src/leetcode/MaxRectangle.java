package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-28
 * Time: PM6:06
 * To change this template use File | Settings | File Templates.
 */
public class MaxRectangle {
    public int maximalRectangle(char[][] matrix) {
        int xLen = matrix.length;
        if(xLen == 0)
            return 0;
        int yLen = matrix[0].length;
        if(yLen == 0)
            return 0;
        int arr[] = new int[yLen];
        int ret = 0;
        for(int i = 0; i < xLen; i ++) {
            for(int j = 0; j <yLen; j++) {
                if(matrix[i][j] == '1')
                    arr[j] ++;
                else
                    arr[j] = 0;
            }
            ret = Math.max(ret, maxArea(arr));
        }
        return ret;
    }

    private int maxArea(int[] arr) {
        int ret = 0;
        int len = arr.length;
        int left[] = new int[len];
        int right[] = new int[len];
        List<Integer> stack = new ArrayList<Integer>();

        for(int i = 0; i < len; i ++) {
            while(stack.size() > 0) {
                int preIdx = stack.get(stack.size() - 1);
                if(arr[preIdx] >= arr[i]) {
                    stack.remove(stack.size() -1);
                } else
                    break;
            }
            if(stack.size() == 0)
                left[i] = 0;
            else
                left[i] = stack.get(stack.size() - 1) + 1;
            stack.add(i);
        }
        stack.clear();

        for(int i = len -1 ; i >= 0; i --) {
            while(stack.size() > 0) {
                int preIdx = stack.get(stack.size() - 1);
                if(arr[preIdx] >= arr[i]) {
                    stack.remove(stack.size() -1);
                } else
                    break;
            }
            if(stack.size() == 0)
                right[i] = len - 1;
            else
                right[i] = stack.get(stack.size() - 1) - 1;
            stack.add(i);
        }

        for(int i = 0 ; i < len ; i ++) {
            ret = Math.max(ret, (right[i] - left[i] + 1) * arr[i]);
        }

        return ret;
    }
}
