package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-7
 * Time: AM12:55
 * To change this template use File | Settings | File Templates.
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = null;
        ListNode next = null;
        ListNode start = null;
        ListNode end   = null;
        ListNode ret = null;
        ListNode cur = head;

        if (k <= 1 || head == null)
            return head;


        while (cur != null) {
            pre   = end;
            start = cur;
            for (int i = 1; i < k; i ++) {
                cur = cur.next;
                if (cur == null)
                    break;
            }

            if (cur == null)
                break;

            end = cur;
            next = end.next;
            end.next = null;

            ListNode p1 = null;
            ListNode p2 = null;
            ListNode p3 = null;

            p1 = start;
            p2 = start.next;
            p1.next = null;
            end = p1;

            while (p2 != null) {
                p3 = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = p3;
                start = p1;
            }

            if (pre == null) {
                ret = start;
            } else {
                pre.next = start;
            }
            end.next = next;
            cur = next;
        }

        if (ret == null)
            ret = head;

        return ret;

    }
}
