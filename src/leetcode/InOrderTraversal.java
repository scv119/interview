package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-26
 * Time: PM10:46
 * To change this template use File | Settings | File Templates.

 TreeNode* current = root;
 vector<TreeNode*> stack;

 while (current || !stack.empty()) {
 if (current) {
 stack.push_back(current);
 current = current->left;
 } else {
 current = stack.back();
 stack.pop_back();
 cout << current->key << endl;
 current = current->right;
 }
 }



 */



public class InOrderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        List<TreeNode> stack = new ArrayList<TreeNode>();
        ArrayList<Integer> ret = new ArrayList<Integer>();

        if(root == null)
            return ret;

        TreeNode cur = root;
        while( cur.left != null ) {
            stack.add(cur);
            cur = cur.left;
        }

        while(cur != null) {
            ret.add(cur.val);

            if(cur.right != null) {
                stack.add(cur);
                cur = cur.right;

                while(cur.left != null) {
                    stack.add(cur);
                    cur = cur.left;
                }

            } else {

                boolean find = false;
                while(stack.size() > 0) {
                    TreeNode parent = stack.remove(stack.size() - 1);
                    if(parent.left == cur) {
                        find = true;
                        cur = parent;
                        break;
                    } else {
                        cur = parent;
                    }
                }

                if(!find)
                    break;

            }
        }
        return ret;

    }

}
