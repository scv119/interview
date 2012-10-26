package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-26
 * Time: PM10:05
 * To change this template use File | Settings | File Templates.
 */
public class AddTwoNumberInLinkList {
    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) {
                     val = x;
                    next = null;
                }
         }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || (l1.val == 0 && l1.next == null))
            return l2;
        if(l2 == null || (l2.val == 0 && l2.next == null))
            return l1;

        int carry = 0;
        ListNode head = null;
        ListNode cur  = null;

        while(carry != 0 || l1 != null || l2 != null) {
            int value1 = 0;
            int value2 = 0;
            if(l1 != null)
                value1 = l1.val;
            if(l2 != null)
                value2 = l2.val;
            int sum = carry + value1 + value2;
            carry = sum / 10;
            sum   = sum % 10;

            if(cur == null) {
                head = cur = new ListNode(sum);
            } else {
                ListNode tmp = new ListNode(sum);
                cur.next = tmp;
                cur = tmp;
            }

            if(l1 != null)
                l1 = l1.next;

            if(l2 != null)
                l2 = l2.next;
        }

        return head;
    }
}
