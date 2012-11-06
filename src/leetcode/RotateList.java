package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-6
 * Time: PM11:57
 * To change this template use File | Settings | File Templates.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        ListNode p1 = null;
        ListNode p2 = null;

        if (head == null)
            return head;

        int len = 1;
        ListNode cur = head;
        while (cur.next != null){
            cur = cur.next;
            len ++;
        }

        n = n % len;

        if (n == 0)
            return head;

        p1 = head;

        for (int i = 1; i < n; i ++)
            p1 = p1.next;

        while (p1.next != null) {
            p1 = p1.next;
            if (p2 == null)
                p2 = head;
            else
                p2 = p2.next;
        }

        if (p2 == null)
            return head;

        p1.next = head;
        head = p2.next;
        p2.next = null;
        return head;
    }
}
