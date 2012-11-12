package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 11/9/12
 * Time: 5:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class MaxPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        this.max = Integer.MIN_VALUE;
        solve(root);
        return max;
    }

    private int solve(TreeNode root) {
        if (root == null)
            return 0;
        int left = solve(root.left);
        int right = solve(root.right);
        this.max = Math.max(root.val + left + right, max);
        return Math.max(root.val + Math.max(0, Math.max(left, right)), 0);
    }
}
