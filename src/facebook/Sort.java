package facebook;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-22
 * Time: AM11:12
 * To change this template use File | Settings | File Templates.
 */

/*
Quick Sort
Merge Sort
*/

public class Sort {
    public static void quickSort(int[] arr) {
        if(arr != null && arr.length > 1)
            quickSort(arr, 0, arr.length - 1);
    }


    private static void quickSort(int[] arr, int start, int end) {
        if(end >= arr.length || start > end)
            throw new RuntimeException("Invalid argument");
        if(start == end)
            return;
        int pidx = partition(arr, start, end);
        if(pidx > start)
            quickSort(arr, start, pidx-1);
        if(pidx < end)
            quickSort(arr, pidx+1, end);

    }

    private static int partition(int[] arr, int start, int end) {
        int rand = start + (int)((end - start + 1) * Math.random());
        swap(arr, start, rand);
        int sidx = start + 1;
        int eidx = end;
        int pivot = arr[start];
        while(sidx <= eidx) {
            if(arr[sidx] >= pivot) {
                swap(arr, sidx, eidx);
                eidx --;
            } else {
                sidx ++;
            }
        }
        swap(arr, start, eidx);
        return eidx;
    }

    public static void mergeSort(int[] arr) {
        if(arr != null && arr.length > 1)
            mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if(end >= arr.length || start > end)
            throw new RuntimeException("Invalid argument");
        if(start == end)
            return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1,  end);

        int tmp[] = new int[end - start + 1];
        int idx = 0;

        int idx1 = start;
        int idx2 = mid+1;

        while(idx < tmp.length) {
            if(idx1 > mid) {
                tmp[idx] = arr[idx2++];
            } else if(idx2 > end) {
                tmp[idx] = arr[idx1++];
            } else if(arr[idx1] < arr[idx2]) {
                tmp[idx] = arr[idx1++];
            } else {
                tmp[idx] = arr[idx2++];
            }
            idx ++;
        }

        for(int i = 0; i < tmp.length ;i ++) {
            arr[start + i] = tmp[i];
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void showArray(int[] arr) {
        for(int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = new int[100];

        for(int i = 0 ; i < 100 ; i ++) {
            arr[i] = 100 - i;
        }
        mergeSort(arr);
        showArray(arr);

        for(int i = 0 ; i < 100 ; i ++) {
            arr[i] = 100 - i;
        }
        quickSort(arr);
        showArray(arr);
    }

}