package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-4
 * Time: PM10:46
 * To change this template use File | Settings | File Templates.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode sHead = null;
        ListNode bHead = null;
        ListNode sNow  = null;
        ListNode bNow  = null;

        while (head != null) {
            if (head.val < x) {
                if (sHead == null)
                    sHead = sNow = head;
                else {
                    sNow.next = head;
                    sNow = sNow.next;
                }
            } else {
                if (bHead == null)
                    bHead = bNow = head;
                else {
                    bNow.next = head;
                    bNow = bNow.next;
                }
            }
            ListNode tmp = head.next;
            head.next = null;
            head = tmp;
        }

        if (sHead != null && bHead != null)
            sNow.next = bHead;

        return sHead != null ? sHead : bHead;
    }
}
