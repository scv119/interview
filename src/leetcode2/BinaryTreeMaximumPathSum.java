package leetcode2;

import leetcode.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 11/13/12
 * Time: 9:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreeMaximumPathSum {
    int ret = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        ret = Integer.MIN_VALUE;
        solve(root);
        return ret;
    }

    int solve(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(solve(root.left), 0) ;
        int right = Math.max(solve(root.right), 0);
        int val = root.val + left + right;
        ret = Math.max(ret, val);
        return Math.max(0, root.val + Math.max(left, right));
    }
}
