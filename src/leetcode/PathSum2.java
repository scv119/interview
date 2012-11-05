package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-5
 * Time: AM9:11
 * To change this template use File | Settings | File Templates.
 */
public class PathSum2 {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        int value = 0;

        while (root != null || stack.size() > 0) {
            if (root != null) {
                value += root.val;
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.right == null || root.right == pre) {
                    if (root.left == null && root.right == null && value == sum) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        for (int i = 0; i < stack.size(); i ++) {
                            list.add(stack.get(i).val);
                        }
                        list.add(root.val);
                        ret.add(list);
                    }

                    value -= root.val;
                    pre = root;
                    root = null;
                } else {
                    stack.push(root);
                    root = root.right;
                }
            }
        }
        return ret;
    }
}
