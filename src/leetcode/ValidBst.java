package leetcode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 11/12/12
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class ValidBst {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //assuming no nodes value equals MIN_VALUE
        long pre = Long.MIN_VALUE;

        while (root != null || stack.size() > 0) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();

                if (root.val <= pre)
                    return false;
                pre = root.val;

                root = root.right;
            }
        }
        return true;
    }
}
