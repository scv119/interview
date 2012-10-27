package phone1;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-27
 * Time: PM3:12
 * To change this template use File | Settings | File Templates.
 */
public class Node {
    int value;
    Node next;


    public static Node reverse(Node head) {
        Node pre;
        Node now;
        Node next;

        pre = head;

        if(pre == null)
            return null;

        now = pre.next;

        if(now == null) {
            return pre;
        }

        next = now.next;

        while(next != null) {
            now.next = pre;
            pre = now;
            now = next;
            next = next.next;
        }

        now.next = pre;

        head.next = null;

        head = now;

        return head;
    }
}