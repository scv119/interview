package leetcode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-7
 * Time: AM12:08
 * To change this template use File | Settings | File Templates.
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();

        if (p == null && q != null)
            return false;

        while (p != null || stack1.size() != 0) {
            if (p != null) {
                if (q == null || q.val != p.val)
                    return false;
                stack1.push(p);
                stack2.push(q);
                p = p.left;
                q = q.left;
            } else {
                if (stack1.size() != stack2.size())
                    return false;
                p = stack1.pop();
                q = stack2.pop();
                p = p.right;
                q = q.right;

                if (p == null && q != null)
                    return false;
            }
        }

        return true;
    }
}
