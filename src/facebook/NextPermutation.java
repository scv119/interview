package facebook;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-22
 * Time: AM10:59
 * To change this template use File | Settings | File Templates.
 */
/*
.给一个整数，求next permutation 就是数字组成一样的 但是比这个数大的最小的一
个数
*/

public class NextPermutation {

    public static int solve(int value) {
        int[] count = new int[10];
        int tmp = value;
        int pre = -1;
        int remain = -1;
        boolean find = false;
        while(true && tmp != 0) {
            remain = tmp%10;
            tmp = tmp / 10;
            count[remain] ++;

            if(pre != -1 && pre > remain) {
                find = true;
                break;
            }

            pre = remain;
        }

        if(!find)
            throw new RuntimeException(value + " is the biggest permutation");

        int ret = tmp;
        int idx = remain + 1;
        for(; idx <= 9 ;idx ++ ) {
            if(count[idx] > 0)
                break;
        }

        ret = ret * 10 + idx;
        count[idx] --;

        for(int i = 0; i <= 9; i ++) {
            while(count[i] > 0) {
                count[i] --;
                ret = ret * 10 + i;
            }
        }

        return ret;
    }

        public static void nextPermutation(int[] num) {
            int idx1 = -1;
            for(int i = num.length - 2; i >= 0; i --) {
                if(num[i] < num[i+1]) {
                    idx1 = i;
                    break;
                }
            }

            if(idx1 == -1)
                return;

            int idx2 = -1;
            for(int j = num.length -1; j > idx1; j --) {
                if(num[j] > num[idx1]) {
                    idx2 = j;
                    break;
                }
            }

            int tmp = num[idx1];
            num[idx1] = num[idx2];
            num[idx2] = tmp;

            idx1 ++;
            idx2 = num.length - 1;
            while(idx1 < idx2) {
                tmp = num[idx1];
                num[idx1] = num[idx2];
                num[idx2] = tmp;
                idx1 ++;
                idx2 --;
            }

    }

    static void showResult(int i) {
        System.out.print(i + " : ");
        try{
            System.out.println(solve(i));
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]) {
        nextPermutation(new int[]{1,2});
    }
}