package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-29
 * Time: PM4:16
 * To change this template use File | Settings | File Templates.
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        if(root.left == null || root.right == null)
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
