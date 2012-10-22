package facebook;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-22
 * Time: PM2:51
 * To change this template use File | Settings | File Templates.
 */
/*
LCA of BST

*/

public class LCA {
    int value = Integer.MIN_VALUE;
    LCA lchild;
    LCA rchild;

    public  static void add(LCA root, int value) {
        if(root.value == Integer.MIN_VALUE)
            root.value = value;
        else {
            if(root.value < value) {
                if(root.rchild == null)
                    root.rchild = new LCA();
                add(root.rchild, value);
            } else {
                if(root.lchild == null)
                    root.lchild = new LCA();
                add(root.lchild, value);
            }
        }
    }

    public static LCA lca(LCA root, int value1, int value2) {
        if(value1 > value2) {
            int tmp = value1;
            value1 = value2;
            value2 = tmp;
        }

        if(root == null || root.value == Integer.MIN_VALUE)
            return null;

        if( value2 < root.value ) {
            return lca(root.lchild, value1, value2);
        } else if(value2 == root.value) {
            if(find(root.lchild, value1) != null)
                return root;
            else
                return null;
        } else if(value2 > root.value && value1 < root.value) {
            if(find(root.lchild, value1) != null && find(root.rchild,value2) != null)
                return root;
            else
                return null;
        } else if (value1 == root.value) {
            if(find(root.rchild, value2) != null)
                return root;
            else
                return null;
        }
        return lca(root.rchild, value1, value2);
    }

    public static LCA find(LCA node, int value) {
        if(node == null || node.value == Integer.MIN_VALUE)
            return null;
        if(node.value == value)
            return node;
        if(node.value < value)
            return find(node.rchild, value);
        return find(node.lchild, value);
    }

    static void showResult(LCA node, int i, int j) {
        LCA ret = lca(node, i, j);
        if(ret == null)
            System.out.println("NIL");
        else
            System.out.println(ret.value);
    }

    public static void main(String args[]) {
        LCA root = new LCA();
        add(root, 5);
        for(int i = 0; i < 10; i ++)
            if ( i != 5 )
                add(root, i);
        showResult(root, 1, 3);
        showResult(root, 2, 3);
        showResult(root, 1, 4);
        showResult(root, 1, 9);
        showResult(root, 5, 10);
    }
}