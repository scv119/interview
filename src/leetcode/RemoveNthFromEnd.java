package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-6
 * Time: AM10:00
 * To change this template use File | Settings | File Templates.
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode pre = null;

        if (n == 0)
            return head;


        for (int i = 0; i < n - 1; i ++) {
            if (p2 == null)
                p2 = head;
            else
                p2 = p2.next;
        }

        p1 = head;
        if (p2 == null)
            p2 = head;
        else
            p2 = p2.next;

        while (p2.next != null) {
            pre = p1;
            p1 = p1.next;
            p2 = p2.next;
        }

        if (pre == null)
            return p1.next;

        pre.next = p1.next;
        return head;
    }
}
