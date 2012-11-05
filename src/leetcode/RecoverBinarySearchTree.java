package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-5
 * Time: PM10:22
 * To change this template use File | Settings | File Templates.
 */
public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();

        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root != null || stack.size() > 0) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root);
                root = root.right;
            }
        }

        int first = -1;
        int second = -1;

        int idx = 0;

        for (; idx < list.size(); idx ++) {
            int pre = idx == 0 ? Integer.MIN_VALUE : list.get(idx-1).val;
            int next = idx == list.size() - 1 ? Integer.MAX_VALUE : list.get(idx+1).val;
            int now  = list.get(idx).val;

            if (first == -1 && now > next) {
                first = idx;
                idx ++;
            } else if (first != -1 && second == -1 && now < pre) {
                second = idx;
            }
        }

        if (second == -1)
            second = first + 1;

        if (first != -1) {
            TreeNode node1 = list.get(first);
            TreeNode node2 = list.get(second);
            int tmp = node1.val;
            node1.val = node2.val;
            node2.val = tmp;
        }

        return;
    }
}
