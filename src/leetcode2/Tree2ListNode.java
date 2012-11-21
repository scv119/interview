package leetcode2;

import leetcode.TreeNode;

public class Tree2ListNode {
    TreeNode pre = null;
    TreeNode head = null;

    public TreeNode flatten(TreeNode root) {
        pre = null;
        head = null;
        solve(root);
        if (head != null) {
            head.left = pre;
            pre.right = head;
        }
        return head;
    }

    private void solve(TreeNode root) {
        if (root == null)
            return;
        solve(root.left);
        if (pre != null)
            pre.right = root;
        else
            head = root;
        root.left = pre;
        pre = root;
        solve(root.right);
    }

    public static void main(String args[]) {
        Tree2ListNode tl = new Tree2ListNode();
        TreeNode root = new TreeNode(2);
        TreeNode ret = tl.flatten(root);

        for (int i = 0; i < 4; i ++) {
            System.out.println(ret.val);
            ret = ret.right;
        }
    }

}
