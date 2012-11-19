package leetcode2;

import leetcode.ListNode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-18
 * Time: PM3:47
 * To change this template use File | Settings | File Templates.
 */
public class ReverseK {
    public class Solution {
        public ListNode reverseKGroup(ListNode head, int n) {
            ListNode senti = new ListNode(-1);
            senti.next = head;
            ListNode cur = senti;

            while (cur.next != null) {
                ListNode pre = cur;
                ListNode tail = cur.next;
                cur = cur.next;
                ListNode next = cur.next;

                int count = 1;
                for (int i = 1; i < n; i ++) {
                    if (next == null)
                        break;
                    count = i + 1;
                    ListNode tmp = next.next;
                    next.next = cur;
                    cur = next;
                    next = tmp;
                }


                pre.next = cur;
                tail.next = next;
                cur = tail;

                if (count != n) {
                    n = count;
                    cur = pre;
                }
            }

            return senti.next;

        }
    }
}
