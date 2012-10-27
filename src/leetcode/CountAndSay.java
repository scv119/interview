package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-27
 * Time: PM9:04
 * To change this template use File | Settings | File Templates.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        List<Integer> cur   = new ArrayList<Integer>();
        List<Integer> next  = new ArrayList<Integer>();

        cur.add(1);

        for(int i = 1; i < n; i ++) {
            int value = 0;
            int count = 0;
            for(int j = 0; j < cur.size(); j ++) {
                int v = cur.get(j);
                if(v == value) {
                    count ++;
                } else if (value == 0) {
                    value = v;
                    count = 1;
                } else {
                    next.add(count);
                    next.add(value);
                    value = v;
                    count = 1;
                }
            }
            if(value != 0) {
                next.add(count);
                next.add(value);
            }
            List<Integer> tmp = cur;
            cur = next;
            next = tmp;
            next.clear();
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < cur.size(); i ++) {
            sb.append(cur.get(i));
        }
        return sb.toString();
    }
}
