package leetcode2;

import leetcode.TreeNode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-14
 * Time: AM9:47
 * To change this template use File | Settings | File Templates.
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        stack.push(root);

        while (stack.size() > 0) {
            root = stack.pop();
            if (root.right != null)
                stack.push(root.right);
            if (root.left !=null)
                stack.push(root.left);
            root.left = root.right = null;
            if (pre != null)
                pre.right = root;
            pre = root;
        }
        return;
    }
}
