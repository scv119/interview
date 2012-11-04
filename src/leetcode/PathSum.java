package leetcode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-4
 * Time: PM11:43
 * To change this template use File | Settings | File Templates.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
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
                    if (root.right == null && root.left == null && value == sum)
                        return true;
                    pre = root;
                    value = value - root.val;
                    root = null;
                } else {
                    stack.push(root);
                    root = root.right;
                }
            }
        }

        return false;
    }
}
