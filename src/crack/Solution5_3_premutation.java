package crack;

public class Solution5_3_premutation {
    public void nextPermutation(int[] arr) {
        int first = -1;
        for (int i = arr.length - 2; i >= 0; i --) {
            if (arr[i] < arr[i + 1]) {
                first = i;
                break;
            }
        }

        if (first == -1)
            return;
        int second = -1;

        for (int i = arr.length - 1; i > first; i --) {
            if (arr[i] > arr[first]) {
                second = i;
                break;
            }
        }

        swap(arr, first, second);

        first = first + 1;
        second = arr.length - 1;

        while (first < second) {
            swap(arr, first ++, second --);
        }

        return;
    }

    public void prePermutation(int[] arr) {
        int first = -1;

        for (int i = arr.length - 2; i >= 0; i --) {
            if (arr[i] > arr[i + 1]) {
                first = i;
                break;
            }
        }

        if (first == -1)
            return;

        int second = -1;

        for (int i = arr.length - 1; i > first; i -- ) {
            if (arr[i] < arr[first]) {
                second = i;
                break;
            }
        }

        swap(arr, first, second);
        first = first + 1;
        second = arr.length - 1;

        while (first < second) {
            swap (arr, first ++, second --);
        }

        return;
    }


    void swap(int A[], int x, int y) {
        A[x] = A[x] + A[y] - (A[y] = A[x]);
    }

    public void print(int arr[]) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Solution5_3_premutation sol = new Solution5_3_premutation();
        int arr[] = new int[]{0,0,1,1,0,1};
        for (int i = 0; i < 6; i ++) {
            sol.print(arr);
            sol.nextPermutation(arr);
        }
        System.out.println("====");

        for (int i = 0; i < 6; i ++) {
            sol.print(arr);
            sol.prePermutation(arr);
        }
    }


}
