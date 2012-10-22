package facebook;

import java.util.LinkedList;
import java.util.Queue;

//find all of the max of length K window in an lenght N array  O(n)
public class KinN {
    public static int[] solve(int arr[], int k) {
        int ret[] = new int[arr.length];

        int idx = 0;

        LinkedList<Integer> dataQ = new LinkedList<Integer>();
        LinkedList<Integer> maxQ  = new LinkedList<Integer>();

        for(int i = 0; i < arr.length; i ++) {
            int value = arr[i];
            dataQ.add(i);
            while(maxQ.size() > 0 && arr[maxQ.get(maxQ.size()-1)] < value) {
                maxQ.remove(maxQ.size() - 1);
            }
            maxQ.add(i);

            if(dataQ.size() > k) {
                int topIdx = dataQ.get(0);
                if(maxQ.size() > 0 && maxQ.get(0) == topIdx) {
                    maxQ.pop();
                }
                dataQ.pop();
            }

            ret[idx++] = arr[maxQ.get(0)];
        }

        return ret;
    }

    static void printArray(int[] arr) {
        for(int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        printArray(solve(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3));

    }
}