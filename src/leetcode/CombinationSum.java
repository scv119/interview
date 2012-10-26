package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-27
 * Time: AM12:26
 * To change this template use File | Settings | File Templates.
 */
public class CombinationSum {
        public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
            ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

            Arrays.sort(candidates);

            //assume candidates has no dups

            if(candidates == null || candidates.length == 0)
                return ret;

            solve(ret, candidates, 0, target, new ArrayList<Integer>());

            return ret;

        }

        private void solve(ArrayList<ArrayList<Integer>> save, int[] candidates,
                           int canIdx, int target, List<Integer> list) {
            if(target == 0) {
                ArrayList<Integer> ret = new ArrayList<Integer>();
                ret.addAll(list);
                save.add(ret);
                return;
            }

            if(canIdx >= candidates.length)
                return;
            //pune
            if(target < candidates[canIdx])
                return;

            int count = 0;
            while(target >= 0) {
                solve(save, candidates, canIdx + 1, target, list);
                target = target - candidates[canIdx];
                list.add(candidates[canIdx]);
                count ++;
            }
            for(int i = 0 ; i < count; i ++)
                list.remove(list.size() - 1);
            return;

        }
}
