package leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 11/12/12
 * Time: 11:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class TwoSum {
    class Item implements Comparable {
        int idx;
        int value;

        @Override
        public int compareTo(Object o) {
            return value - ((Item)o).value;
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        Item[] list = new Item[numbers.length];
        for (int i = 0; i < numbers.length; i ++) {
            list[i] = new Item();
            list[i].idx = i;
            list[i].value = numbers[i];
        }

        Arrays.sort(list);

        int start = 0;
        int end   = list.length - 1;

        while (start != end) {
            int val = list[start].value + list[end].value;
            if (val == target)
                break;
            if (val < target)
                start ++;
            else
                end   --;
        }

        return new int[]{Math.min(list[start].idx, list[end].idx) + 1,
                Math.max(list[start].idx, list[end].idx) + 1
        };

    }
}
