package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-28
 * Time: PM5:41
 * To change this template use File | Settings | File Templates.
 */
public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    private int depth(TreeNode root) {
        if(root ==  null)
            return 0;
        return Math.max(depth(root.left), depth( root.right)) + 1;
    }
}
