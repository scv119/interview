package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-29
 * Time: PM3:51
 * To change this template use File | Settings | File Templates.
 */
public class MergeKSortedList {
    private static final Node EMPTY = new LeafNode(null);
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists.size() == 0)
            return null;

        List<Node> cur = new ArrayList<Node>();
        List<Node> next = new ArrayList<Node>();

        for(int i = 0; i < lists.size(); i += 2) {
            Node first = new LeafNode(lists.get(i));
            Node second = EMPTY;
            if(i + 1 < lists.size()) {
                second = new LeafNode(lists.get(i+1));
            }
            cur.add(first);
            cur.add(second);
        }

        Node root = null;
        while(cur.size() != 1) {
            for(int i = 0; i < cur.size(); i += 2) {
                Node first = cur.get(i);
                Node second = EMPTY;
                if(i+1 < cur.size())
                    second = cur.get(i+1);
                next.add(new TreeNode(first, second));
            }
            List<Node> tmp = cur;
            cur = next;
            next = tmp;
            next.clear();
        }
        root = cur.get(0);
        ListNode head = null;
        ListNode now  = null;
        while(true) {
            ListNode tmp = root.next();
            if(tmp == null)
                break;
            if(head == null) {
                head = now = tmp;
            } else {
                now.next = tmp;
                now = now.next;
            }
        }
        return head;

    }

    interface Node {
        ListNode next();
    }

    static class TreeNode implements Node {
        Node left;
        Node right;
        ListNode lfirst;
        ListNode rfirst;

        public TreeNode(Node left, Node right) {
            this.left = left;
            this.right = right;
            this.lfirst = left.next();
            this.rfirst = right.next();
        }

        public ListNode next() {
            ListNode ret = null;
            if(lfirst == null && rfirst == null)
                return null;
            if(lfirst == null ) {
                ret = rfirst;
                rfirst = right.next();
                return ret;
            }
            if(rfirst == null) {
                ret = lfirst;
                lfirst = left.next();
                return ret;
            }
            if(lfirst.val < rfirst.val) {
                ret = lfirst;
                lfirst = left.next();
                return ret;
            } else {
                ret = rfirst;
                rfirst = right.next();
                return ret;
            }
        }
    }

    static class LeafNode implements Node {
        ListNode head;

        public LeafNode(ListNode head) {
            this.head = head;
        }

        public ListNode next() {
            if(head == null)
                return null;
            ListNode tmp = head;
            head = head.next;
            tmp.next = null;
            return tmp;

        }
    }
}
