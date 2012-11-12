package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-10
 * Time: PM11:58
 * To change this template use File | Settings | File Templates.
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode ret = null;
        ListNode pre = null;
        ListNode cur = null;

        cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            if (next == null)
                break;

            cur.next = next.next;
            next.next = cur;

            if (pre != null) {
                pre.next = next;
            } else
                ret = next;

            pre = cur;
            cur = cur.next;
        }

        if (ret == null)
            ret = head;

        return ret;
    }
}
