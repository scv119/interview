package facebook;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 10/24/12
 * Time: 3:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShiftFind {
    public static int find(int arr[]) {
        int s = 0;
        int e = arr.length - 1;
        if(arr[s] < arr[e])
            return arr[e];
        while(s < e - 1) {
            int mid = (s + e) / 2;
            if(arr[mid] < arr[s])
                e = mid;
            else if(arr[mid] > arr[e])
                s = mid;
        }
        return arr[s];
    }

    public static void test(int n) {
        int arr[] = new int[n];
        for(int off = 0 ; off < n; off ++)   {
            for(int i = 0 ; i < n; i ++)
                arr[(i+off)%n] = i;
            assert (find(arr) == n - 1);
        }
    }


    public static void main(String args[]) {
        for(int i = 1; i < 1024; i ++)
            test(i);
    }
}