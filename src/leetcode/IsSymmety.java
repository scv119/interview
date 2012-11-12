package leetcode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-11
 * Time: AM12:06
 * To change this template use File | Settings | File Templates.
 */
public class IsSymmety {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> lStack = new Stack<TreeNode>();
        Stack<TreeNode> rStack = new Stack<TreeNode>();

        if (root != null) {
            lStack.push(root);
            rStack.push(root);
        }

        TreeNode lNode = null;
        TreeNode rNode = null;

        while (lStack.size() > 0) {
            if (lStack.size() != rStack.size())
                return false;

            lNode = lStack.pop();
            rNode = rStack.pop();

            if (lNode.val != rNode.val || lNode.left == null && rNode.right != null ||
                    lNode.left != null && rNode.right == null || lNode.right == null &&
                    rNode.left != null || lNode.right != null && rNode.left == null)
                return false;

            if (lNode.right != null) {
                lStack.push(lNode.right);
                rStack.push(rNode.left);
            }

            if (lNode.left != null) {
                lStack.push(lNode.left);
                rStack.push(rNode.right);
            }
        }

        return true;

    }
}
