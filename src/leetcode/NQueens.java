package leetcode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-1
 * Time: PM1:39
 * To change this template use File | Settings | File Templates.
 */
public class NQueens {

        public ArrayList<String[]> solveNQueens(int n) {
            Set<Answer> ret = new HashSet<Answer>();
            List<Integer> pre = new ArrayList<Integer>();
            ArrayList<String[]> answer = new ArrayList<String[]>();

            for (int i = 0; i < (n + 1)/2;  i ++) {
                pre.add(i);
                solve(ret, pre, n);
                pre.remove(pre.size() - 1);
            }

            for(Answer asw : ret) {
                answer.add(asw.toStrings());
            }
            return answer;
        }

        private void solve(Set<Answer> ret, List<Integer> pre, int n) {
            if (pre.size() == n) {
                ret.add(new Answer(pre, true));
                ret.add(new Answer(pre, false));
                return;
            }

            int arr[] = new int[n];
            Arrays.fill(arr, 1);
            int cur = pre.size();
            for(int i = 0; i < pre.size(); i ++) {
                int value = pre.get(i);
                arr[value] = 0;
                int left  = value - (cur - i);
                if (left >= 0)
                    arr[left] = 0;
                int right = value + (cur - i );
                if (right < n)
                    arr[right] = 0;
            }

            for(int i = 0; i < arr.length; i ++) {
                if (arr[i] == 0)
                    continue;
                pre.add(i);
                solve(ret, pre, n);
                pre.remove(pre.size() - 1);
            }
        }



        class Answer {
            public Answer(List<Integer> list, boolean reverse) {
                StringBuffer sb = new StringBuffer();
                arr = new int[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    if (!reverse)
                        arr[i] = list.get(i);
                    else
                        arr[i] = list.size() - 1 - list.get(i);

                    sb.append(arr[i]);
                }
                hashCode = sb.toString().hashCode();
            }

            final int[] arr;
            final int hashCode;

            @Override
            public boolean equals(Object o) {
                if (!(o instanceof Answer))
                    return false;
                Answer dest = (Answer)o;
                if(dest.arr.length != this.arr.length)
                    return false;

                boolean equal = true;

                for (int i = 0; i < arr.length; i ++) {
                    if (arr[i] != dest.arr[i]) {
                        equal = false;
                        break;
                    }
                }
                return equal;
            }

            @Override
            public int hashCode() {
                return hashCode;
            }

            public String[] toStrings() {
                String[] ret = new String[arr.length];
                for (int i = 0; i < arr.length; i ++) {
                    StringBuffer sb = new StringBuffer();
                    for(int j = 0; j < arr.length; j ++)
                        if ( j == arr[i])
                            sb.append('Q');
                        else
                            sb.append('.');
                    ret[i] = sb.toString();
                }
                return ret;
            }
        }

    public static void main(String args[]) {
        NQueens nq = new NQueens();
        for(int i = 0; i < 100; i ++) {
            Date now = new Date();
            int size = nq.solveNQueens(i).size();
            Date end = new Date();
            System.out.println(i + ":" + size + ":" + (end.getTime() - now.getTime()));
        }
    }
}
