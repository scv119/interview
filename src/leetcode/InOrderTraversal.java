package leetcode;

import java.util.*;

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

    public ArrayList<Integer> inorderTraversal1(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root != null || stack.size() > 0) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                ret.add(root.val);
                root = root.right;
            }
        }
        return ret;
    }

    public ArrayList<Integer> postOrderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;

        while (root != null || stack.size() > 0) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if ( root.right == null || pre != null && pre == root.right ) {
                    ret.add(root.val);
                    pre  = root;
                    root = null;
                } else {
                    stack.push(root);
                    root = root.right;
                }
            }
        }
        return ret;
    }

    public void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if (root != null)
            stack.add(root);

        while (stack.size() > 0) {
            root = stack.pop();
            if (root.right != null) stack.push(root.right);
            if (root.left  != null) stack.push(root.left);

            System.out.println(root.val);
        }
    }

    public void add(TreeNode node, int value) {
        if (value < node.val) {
            if (node.left != null)
                add(node.left, value);
            else
                node.left = new TreeNode(value);
        } else {
            if (node.right != null)
                add(node.right, value);
            else
                node.right = new TreeNode(value);
        }
    }

    public static void main(String args[]) {
        InOrderTraversal iot = new InOrderTraversal();
        TreeNode root = new TreeNode(5);
        for(int i = 1 ;i < 11; i ++) {
            if(i != 5) {
                iot.add(root, i);
            }
        }

        for(Integer i : iot.inorderTraversal1(root)) {
            System.out.print(i + " ");
        }
        System.out.println();

        for(Integer i : iot.postOrderTraversal(root)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
