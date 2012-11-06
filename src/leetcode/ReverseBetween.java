package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-6
 * Time: PM11:29
 * To change this template use File | Settings | File Templates.
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = null;
        ListNode next = null;

        ListNode start = null;
        ListNode end   = null;

        ListNode cur  = head;
        for (int idx = 1; idx <= n; idx ++) {
            if (idx < m) {
                pre = cur;
            }
            else {
                if (idx == m)
                    start = cur;
                if (idx == n)
                    end   = cur;
            }
            cur = cur.next;
        }

        next = end.next;
        end.next = null;

        ListNode p1 = null;
        ListNode p2 = null;
        ListNode p3 = null;

        end = start;
        p1 = start;
        p2 = p1.next;
        p1.next = null;

        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }

        start = p1;

        end.next = next;

        if (pre == null)
            return start;
        pre.next = start;
        return head;
    }
}
