package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-26
 * Time: PM11:17
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreeLevelOrder {
    public class Solution {
        public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
            ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
            if(root == null)
                return ret;


            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

            int curSize =  1;
            int nextSize = 0;

            queue.offer(root);

            while(curSize > 0) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int i = 0 ; i < curSize; i ++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if(node.left != null) {
                        queue.offer(node.left);
                        nextSize ++;
                    }
                    if(node.right != null) {
                        queue.offer(node.right);
                        nextSize ++;
                    }
                }
                ret.add(list);
                curSize = nextSize;
                nextSize = 0;
            }
            Stack stack;
            return ret;
        }

    }
}
