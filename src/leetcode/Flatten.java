package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-27
 * Time: PM10:32
 * To change this template use File | Settings | File Templates.
 */
public class Flatten {
    public void flatten(TreeNode root) {
        List<TreeNode> stack = new ArrayList<TreeNode>();
        TreeNode pre   = null;
        if(root == null)
            return;
        stack.add(root);
        while(stack.size() > 0) {
            TreeNode cur = stack.remove(stack.size() - 1);
            if(cur.right != null)
                stack.add(cur.right);
            if(cur.left  != null)
                stack.add(cur.left);
            cur.left = null;
            if(pre == null)
                pre = cur;
            else {
                pre.right = cur;
                pre = pre.right;
            }
        }
    }
}
