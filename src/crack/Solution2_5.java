package crack;

import leetcode.ListNode;

public class Solution2_5 {
    public ListNode find(ListNode head) {
        ListNode n1 = head;
        ListNode n2 = head;
        boolean find = false;

        while (n2 != null && n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
            if (n2 == n1) {
                find = true;
                break;
            }
        }

        if (!find)
            return null;

        n1 = head;

        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1;
    }
}
