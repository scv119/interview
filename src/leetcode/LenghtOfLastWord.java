package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-28
 * Time: PM3:03
 * To change this template use File | Settings | File Templates.
 */
public class LenghtOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int len = 0;
        int x = s.length() - 1;
        while(true) {
            if(x < 0)
                break;
            char c = s.charAt(x);
            if(c != ' ')
                break;
            x --;
        }
        for(; x >= 0; x --) {
            if(s.charAt(x) == ' ')
                break;
            len ++;
        }
        return len;

    }
}
