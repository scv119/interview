package facebook;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-22
 * Time: PM3:04
 * To change this template use File | Settings | File Templates.
 */
/*
1.A period of time where users login and logout, given a sets of login and logout time pairs (number N), write a function that can show the number of
users (max Number K) online at any given time.

请问这题怎么做？ 方向应该是要减少每次query的时间，因为预处理的时间要 NlogN应
该是无法减少的。

数据结构要用interval tree， 每次query就是KlogN，这也不快呀。有没有什么更好的
方法。

*/

public class IntervalTree {
    static class Node {
        int start;
        int end;
        int value;

        public Node(int start, int end) {
            this.start = start;
            this.end   = end;
        }

        Node lchild;
        Node rchild;
    }

    private Node root;

    public IntervalTree(int lower, int upper) {
        root = initNode(lower, upper);
    }

    private Node initNode( int start, int end) {
        Node node = new Node(start, end);
        if(start < end) {
            int mid = (start + end) / 2;
            node.lchild = initNode(start, mid);
            node.rchild = initNode(mid + 1, end);
        }
        return node;
    }

    public void addInterval(int start, int end, int value) {
        addInterval(start, end, root, value);
    }

    private void addInterval(int start, int end, Node node, int value) {
        if(start == node.start && end == node.end) {
            node.value += value;
        } else {
            int lstart = Math.max(start, node.lchild.start);
            int lend   = Math.min(end, node.lchild.end);
            if(lstart <= lend)
                addInterval(lstart, lend, node.lchild, value);
            int rstart = Math.max(start, node.rchild.start);
            int rend   = Math.min(end, node.rchild.end);
            if(rstart <= rend)
                addInterval(rstart, rend, node.rchild, value);
        }
    }

    public int getValue(int k) {
        Node cur = root;
        int ret = 0;
        while(cur.start != k || cur.end != k) {
            ret += cur.value;
            if(k <= cur.lchild.end)
                cur = cur.lchild;
            else
                cur = cur.rchild;
        }
        ret += cur.value;
        return ret;
    }

    public static void main(String args[]) {
        IntervalTree it = new IntervalTree(0, 100);
        it.addInterval(0, 10, 1);
        it.addInterval(10, 20, 1);
        it.addInterval(5, 21, 1);
        for(int i = 0 ; i < 22; i ++)
            System.out.println(i + " " + it.getValue(i));

    }

}