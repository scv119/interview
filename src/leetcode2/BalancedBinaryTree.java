package leetcode2;

import leetcode.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 11/13/12
 * Time: 8:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth (TreeNode root) {
        if (root == null)
            return 0;
        int lDep = depth(root.left);
        int rDep = depth(root.right);

        if (lDep < 0 || rDep < 0)
            return -1;

        if (Math.abs(lDep - rDep) > 1)
            return -1;

        return 1 + Math.max(lDep, rDep);
    }
}
