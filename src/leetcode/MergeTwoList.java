package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-29
 * Time: PM4:12
 * To change this template use File | Settings | File Templates.
 */
public class MergeTwoList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode now  = null;
        while(true) {
            if(l1 == null && l2 == null)
                break;
            else if(l1 == null) {
                if(head == null) {
                    head = l2;
                    break;
                } else {
                    now.next = l2;
                    break;
                }
            } else if(l2 == null) {
                if(head == null) {
                    head = l1;
                    break;
                } else {
                    now.next = l1;
                    break;
                }
            } else {
                ListNode tmp = null;
                if(l1.val < l2.val) {
                    tmp = l1;
                    l1 = l1.next;
                    tmp.next = null;
                } else {
                    tmp = l2;
                    l2 = l2.next;
                    tmp.next = null;
                }
                if(head == null) {
                    head = now = tmp;
                } else {
                    now.next = tmp;
                    now = now.next;
                }
            }
        }
        return head;
    }
}
