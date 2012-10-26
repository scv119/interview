package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-26
 * Time: PM10:25
 * To change this template use File | Settings | File Templates.
 */
public class BalancedBinaryTree {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


    public boolean isBalanced(TreeNode root) {
        return depth(root) >= 0;

    }

    private int depth(TreeNode root) {
        if(root == null)
            return 0;
        int ldepth = depth(root.left);
        int rdepth = depth(root.right);

        if(ldepth < 0 || rdepth < 0)
            return -1;
        if(Math.abs(rdepth - ldepth) > 1)
            return -1;
        return Math.max(rdepth, ldepth) + 1;
    }
}
