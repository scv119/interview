package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-26
 * Time: PM11:32
 * To change this template use File | Settings | File Templates.
 */
public class ZigZagLevelOrder {
    /**
     * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Solution {
        public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
            ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>> ();
            if (root == null)
                return ret;

            List<TreeNode> curStack = new ArrayList<TreeNode>();
            List<TreeNode> nextStack = new ArrayList<TreeNode>();

            curStack.add(root);

            boolean l2r = true;

            while (curStack.size() > 0) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                while(curStack.size() != 0) {
                    TreeNode node = curStack.remove(curStack.size() -1 );
                    list.add(node.val);
                    if(l2r) {
                        if(node.left != null) nextStack.add(node.left);
                        if(node.right != null) nextStack.add(node.right);
                    } else {
                        if(node.right != null) nextStack.add(node.right);
                        if(node.left != null) nextStack.add(node.left);
                    }
                }
                ret.add(list);
                l2r = !l2r;

                List<TreeNode> tmp = curStack;
                curStack = nextStack;
                nextStack = tmp;
            }

            return ret;

        }
    }
}
