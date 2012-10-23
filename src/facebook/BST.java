package facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-22
 * Time: AM3:39
 * To change this template use File | Settings | File Templates.
 */
/*
BST : is bst?
      in order next
*/


public class BST {
    public static class Node {
        int value;
        Node lchild;
        Node rchild;
    }

    public static boolean isBST(Node root) {
        int[] ref = new int[1];
        if(root == null)
            return true;
        ref[0] = Integer.MIN_VALUE;
        return isBST(root, ref);
    }

    private static boolean isBST(Node root, int[] ref) {

        if(root.lchild != null) {
            if(!isBST(root.lchild, ref))
            return false;
        }

        if(root.value < ref[0])
            return false;

        ref[0] = root.value;

        if(root.rchild != null) {
            if(!isBST(root.rchild, ref))
            return false;
        }

        return true;
    }
    //assume value is alwalys in bst
    public static int next(Node root, int value) {
        List<Node> stack = new ArrayList<Node>();
        Node cur  = root;
        while(cur != null && cur.value != value) {
            stack.add(cur);
            if(cur.value > value)
                cur = cur.lchild;
            else
                cur = cur.rchild;
        }
        //value not exists
        if(cur == null)
            throw new RuntimeException(value + " not exists");

        if (cur.rchild != null) {
            cur = cur.rchild;
            while(cur.lchild != null)
                cur = cur.lchild;
        } else if(stack.size() == 0) {
            // it is root and last;
            throw new RuntimeException(value + " is last");
        } else {
            boolean find = false;
            while(stack.size() > 0) {
                Node parent = stack.remove(stack.size() - 1);
                if(parent.lchild == cur) {
                    cur = parent;
                    find = true;
                    break;
                } else {
                    cur = parent;
                }
            }
            //it is last value
            if(!find)
                throw new RuntimeException(value + " is last");
        }
        return cur.value;

    }

    public static void add(Node root, int value) {
        if(value < root.value) {
            if(root.lchild != null)
                add(root.lchild, value);
            else {
                root.lchild = new Node();
                root.lchild.value = value;
            }
        }

        if(value > root.value) {
            if(root.rchild != null)
                add(root.rchild, value);
            else {
                root.rchild = new Node();
                root.rchild.value = value;
            }
        }
    }

    public static Node toDoubleLinkedList(Node root) {
        Node[] head = new Node[1];
        Node[] pre  = new Node[1];
        solve(root, head, pre);
        head[0].lchild.rchild = head[0];
        return head[0];
    }

    private static void solve(Node root, Node head[], Node pre[]) {
        if(root.lchild != null)
            solve(root.lchild, head, pre);

        if(pre[0] != null) {
            pre[0].rchild = root;
            root.lchild = pre[0];
        }
        else
            head[0] = root;
        head[0].lchild = root;
        pre[0] = root;

        if(root.rchild != null)
            solve(root.rchild, head, pre);
    }


    public static void main(String args[]) {
        Node root = new Node();
        root.value = 5;
        for(int i = 0; i < 10; i ++ ) {
            if(i != 5)
                add(root, i);
        }
        int value = 0;
//        for(int i = 0; i < 10; i ++ ) {
//            value = next(root, value);
//            System.out.println(value);
//        }
        Node head = toDoubleLinkedList(root);
        for(int i = 0; i < 20 ; i ++) {
            head = head.lchild;
            System.out.println(head.value);
        }
        for(int i = 0; i < 20 ; i ++) {
            head = head.rchild;
            System.out.println(head.value);
        }
    }
}