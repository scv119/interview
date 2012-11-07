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
        ListNode ret = null;
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode cur1 = cur.next;
            ListNode next = cur.next;
            cur.next = null;
            ListNode end = cur;
            int i;
            for (i = 1; i < k; i ++) {
                if (cur1 == null)
                    break;
                ListNode tmp = cur1.next;
                next = tmp;
                cur1.next = cur;
                cur = cur1;
                cur1 = tmp;
            }

            if (i == k) {
                if (ret == null)
                    ret = cur;
                else
                    pre.next = cur;
                pre = end;
                cur = next;
            } else
                k = i;
        }

        return ret;
    }
}
