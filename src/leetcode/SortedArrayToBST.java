package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-27
 * Time: PM8:35
 * To change this template use File | Settings | File Templates.
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] num) {
        return build(num, 0, num.length - 1);
    }

    private TreeNode build(int[] num, int start, int end) {
        if( start > end )
            return null;
        if( start == end )
            return new TreeNode(num[start]);
        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = build( num, start, mid - 1);
        node.right = build( num, mid + 1, end );
        return node;
    }
}
