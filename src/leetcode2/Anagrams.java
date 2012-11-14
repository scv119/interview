package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-14
 * Time: AM10:29
 * To change this template use File | Settings | File Templates.
 */
public class Anagrams {
    class Item implements Comparable {
        String origin;
        String key;

        Item (String input) {
            origin = input;
            char arr[] = input.toCharArray();
            Arrays.sort(arr);
            key = new String(arr);
        }

        @Override
        public int compareTo(Object o) {
            return key.compareTo(((Item)o).key);
        }
    }

    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> ret = new ArrayList<String>();
        Item[] items = new Item[strs.length];
        for (int i = 0; i < strs.length; i++) {
            items[i] = new Item(strs[i]);
        }
        Arrays.sort(items);
        String pre = null;
        int    start = -1;

        for (int i = 0; i < items.length; i ++) {
            if (items[i].key.equals(pre))
                continue;
            if (pre != null && start < i - 1) {
                for (int j = start; j < i; j ++)
                    ret.add(items[j].origin);
            }
            pre = items[i].key;
            start = i;
        }

        if (pre != null && start < items.length - 1)
            for (int j = start; j < items.length; j ++)
                ret.add(items[j].origin);

        return ret;

    }
}
