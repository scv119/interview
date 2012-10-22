package facebook;

/*
Edit distance of 2 string
There are 3 kinds of operation

1. Change
2. Add
3. Insert
*/


public class EditDistance {
    public static int solve(String s1, String s2) {
        if((s1 == null || s1.length() == 0  )&& (s2 == null || s2.length() ==0))
            return 0;
        if(s1 == null || s1.length() == 0)
            return s2.length();

        if(s2 == null || s2.length() == 0)
            return s1.length();
        int dp[][] = new int[s1.length()][s2.length()];

        for(int idx1 = 0; idx1 <s1.length(); idx1 ++)
        for(int idx2 = 0; idx2 <s2.length(); idx2 ++) {
            char char1 = s1.charAt(idx1);
            char char2 = s2.charAt(idx2);
            if(idx1 == idx2 && idx1 == 0) {
                if(char1 != char2)
                    dp[idx1][idx2] = 1;
            } else {
                int ret = Integer.MAX_VALUE;
                if(char1 == char2 ) {
                    if(idx1 > 0 && idx2 > 0)
                        ret = Math.min(dp[idx1-1][idx2-1], ret);
                    else if(idx1 > 0)
                        ret = idx1;
                    else if(idx2 > 0)
                        ret = idx2;
                } else {
                    if(idx1 > 0)
                        ret = Math.min(dp[idx1-1][idx2]+1, ret);
                    if(idx2 > 0)
                        ret = Math.min(dp[idx1][idx2-1]+1, ret);
                    if(idx1 > 0 && idx2 > 0)
                        ret = Math.min(dp[idx1-1][idx2-1]+1, ret);
                }
                dp[idx1][idx2] = ret;
            }
        }
        return dp[s1.length()-1][s2.length()-1];
    }

    public static void main(String args[]) {
        System.out.println(solve("GGATCGA", "GAATTCAGTTA"));
    }

}