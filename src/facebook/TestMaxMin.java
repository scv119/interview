package facebook;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-23
 * Time: PM7:13
 * To change this template use File | Settings | File Templates.
 */
public class TestMaxMin {
    static int count = 0;

    static int[] compare(int i, int j) {
        count ++;
        return new int[]{Math.max(i, j), Math.min(i,j)};
    }

    public static int[] getMaxMin(int arr[], int start, int len) {
        if(len == 1)
            return new int[]{arr[start], arr[start]};
        if(len == 2)
            return compare(arr[start], arr[start+1]);
        int sublen = len /2;
        int[] tmp1 = getMaxMin(arr, start, sublen);
        int[] tmp2 = getMaxMin(arr, start + sublen, len - sublen);

        return new int[]{compare(tmp1[0], tmp2[0])[0], compare(tmp1[0], tmp2[0])[1]};
    }

    public static int test(int len) {
        count = 0;
        int arr[] = new int[len];
        for(int i = 0; i < len;i ++)
            arr[i] = i;
        getMaxMin(arr, 0, len);
        return count;
    }

    public static void main(String args[]) {
        int k = 2;
        for(int i = 1; i < 10; i ++) {
            System.out.println(k + " " + test(k));
            k *= 2;
        }
    }
}
