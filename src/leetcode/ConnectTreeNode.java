package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-5
 * Time: AM10:04
 * To change this template use File | Settings | File Templates.
 */
public class ConnectTreeNode {
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root;

        while (cur != null) {
            TreeLinkNode nHead = null;
            TreeLinkNode nCur  = null;

            while (cur != null) {
                if (cur.left != null) {
                    if (nHead == null)
                        nHead = nCur = cur.left;
                    else {
                        nCur.next = cur.left;
                        nCur = nCur.next;
                    }
                }

                if (cur.right != null) {
                    if (nHead == null)
                        nHead = nCur = cur.right;
                    else {
                        nCur.next = cur.right;
                        nCur = nCur.next;
                    }
                }

                cur = cur.next;
            }
            cur = nHead;
        }

        return;
    }
}
