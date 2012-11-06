package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-6
 * Time: AM9:41
 * To change this template use File | Settings | File Templates.
 */
public class RemoveDuplicateFromList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode now = null;
        ListNode ret = null;
        while (head != null) {
            if (now == null) {
                ret = now = head;
                head = head.next;
                now.next = null;
            } else if (now.val == head.val) {
                head = head.next;
            } else {
                now.next = head;
                now = head;
                head = head.next;
                now.next = null;
            }
        }
        return ret;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode start = null;
        ListNode end   = null;

        ListNode ret = null;
        ListNode now = null;

        while (head != null) {
            if (start == null) {
                start = end = head;
            } else if (start.val != head.val){
                if (start == end) {
                    if (ret == null) {
                        ret = now = start;
                        now.next = null;
                    } else {
                        now.next = start;
                        now = now.next;
                        now.next = null;
                    }
                }
                start = end = head;
            } else {
                end = head;
            }
            head = head.next;
        }

        if (start == end && start != null) {
            if (ret == null) {
                ret = now = start;
                now.next = null;
            } else {
                now.next = start;
                now = now.next;
                now.next = null;
            }
        }

        return ret;

    }
}
