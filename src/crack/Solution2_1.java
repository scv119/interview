package crack;

import leetcode.ListNode;

public class Solution2_1 {
    public ListNode deleteDup(ListNode head) {
        ListNode first = head;
        while (first != null) {
            ListNode pre = first;
            ListNode cur = first.next;
            while(cur != null) {
                if (cur.val == first.val) 
                    pre.next = cur.next;
                else
                    pre = cur;
                cur = cur.next;
            }
            first = first.next;
        }
        return head;
    }

    public void print(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public ListNode construct(int[] arr) {
        ListNode head = null;
        ListNode cur  = null;
        for (int x : arr) {
            if (cur == null) {
                head = cur = new ListNode(x);
            } else {
                cur.next = new ListNode(x);
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String args[]) {
        Solution2_1 so = new Solution2_1();
        ListNode head = so.construct(new int[]{});
        so.print(so.deleteDup(head));
        head = so.construct(new int[]{1, 2, 3, 3 ,3, 2, 1, 2});
        so.print(so.deleteDup(head));
        head = so.construct(new int[]{1});
        so.print(so.deleteDup(head));
    }
}
