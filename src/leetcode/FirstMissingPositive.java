package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-27
 * Time: PM7:06
 * To change this template use File | Settings | File Templates.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] arr) {
        if( arr == null || arr.length == 0)
            return 1;

        int len = arr.length;
        int pos = 0;
        for(int i : arr) {
            if( i > 0)
                pos ++;
        }

        int start = 0;
        int mid   = pos;
        while(start < pos && mid < len) {
            if(arr[start] > 0)
                start ++;
            else {
                swap(arr, start, mid ++);
            }
        }

        for(int i = 0 ; i < pos; i ++) {
            int value = Math.abs(arr[i]) - 1;
            if(value < pos && arr[value] > 0)
                arr[value] = arr[value] * - 1;
        }

        int ret = 0;

        for(int i = 0 ; i < pos; i ++) {
            if(arr[i] > 0) {
                ret = i + 1;
                break;
            }
        }

        if(ret == 0)
            ret = pos + 1;

        return ret;



    }

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
