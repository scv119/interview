package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-10
 * Time: PM11:58
 * To change this template use File | Settings | File Templates.
 */
public class SwapPairs {
    public class Solution {
        public ListNode swapPairs(ListNode head) {

            ListNode cur = head;
            head = null;
            ListNode pre = null;
            while (cur != null && cur.next != null) {
                ListNode next = cur.next.next;
                cur.next.next = cur;

                if (pre == null)
                    head = cur.next;
                else
                    pre.next = cur.next;

                cur.next = next;

                pre = cur;
                cur = next;
            }

            if (head == null)
                head = cur;

            return head;
        }
    }
}
