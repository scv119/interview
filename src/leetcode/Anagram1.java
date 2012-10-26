package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-26
 * Time: PM10:21
 * To change this template use File | Settings | File Templates.
 */
public class Anagram1 {
    class Anagram  implements Comparable{
        String s;
        String sorted;

        public int compareTo(Object o) {
            return this.sorted.compareTo(((Anagram)o).sorted);
        }

        public Anagram(String key) {
            this.s = key;
            char[] arr = key.toCharArray();
            Arrays.sort(arr);
            this.sorted = new String(arr);
        }
    }

    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> ret = new ArrayList<String>();

        Anagram list[] = new Anagram[strs.length];
        for(int i = 0 ; i < strs.length; i ++)
            list[i] = new Anagram(strs[i]);

        Arrays.sort(list);

        int startIdx = 0;
        String sorted = list[0].sorted;


        for(int i = 1 ; i < list.length; i ++ ) {
            if(sorted.equals(list[i].sorted)) {
                ret.add(list[i].s);
            } else {
                if(i > startIdx + 1)
                    ret.add(list[startIdx].s);
                startIdx = i;
                sorted = list[i].sorted;
            }
        }

        if(startIdx != list.length - 1)
            ret.add(list[startIdx].s);

        return ret;

    }
}
