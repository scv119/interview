package facebook;

public class Regex {
    private String p;
    private static final char END = '\0';


    //assuming all the input pattern is valid;
    //need to compress pattern
    public Regex(String pattern) {
        this.p = pattern;
    }

    public boolean match(String s) {
        int pIdx = 0;
        int sIdx = 0;
        int count = 0;
        boolean ret = true;
        while(pIdx <= p.length() && sIdx <= s.length()) {
            char sChar = sIdx < s.length() ? s.charAt(sIdx) : END;
            char pChar = pIdx < p.length() ? p.charAt(pIdx) : END;
            if(pChar == '*') {
                char pPreChar = p.charAt(pIdx - 1);
                if(pPreChar == sChar) {
                    sIdx ++;
                } else {
                    pIdx ++;
                }
            }
            else if(pChar == '+') {
                char pPreChar = p.charAt(pIdx - 1);
                if(pPreChar == sChar) {
                    sIdx ++;
                    count ++;
                } else {
                    if(count > 0)
                        pIdx ++;
                    else {
                        ret = false;
                        break;
                    }
                }
            } else if (pIdx < p.length() - 1 &&
                    ( p.charAt(pIdx + 1) == '+' || p.charAt(pIdx + 1) == '*' )){
                pIdx ++;
                count = 0;
            } else {
                if(pChar == sChar) {
                    pIdx ++;
                    sIdx ++;
                } else {
                    ret = false;
                    break;
                }
            }
        }
        if(ret && sIdx == s.length() + 1 && pIdx == p.length() + 1)
            ret = true;
        else
            ret = false;
        return ret;

    }

    public static void main(String args[]) {
        Regex rg = new Regex("h*e*l*o*");
        System.out.println(rg.match("h"));
        System.out.println(rg.match("helllo"));
        System.out.println(rg.match("helll"));
        System.out.println(rg.match("hel"));
    }
}