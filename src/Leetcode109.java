import java.util.ArrayList;
import java.util.List;

public class Leetcode109 {
    //definition Listnode
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //definition TreeNode
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null){
            return null;
        }
        if (head.next==null){
            return new TreeNode(head.val);
        }

        ListNode end = head.next.next;
        ListNode mid = head;

        while (end!=null&&end.next!=null){
            end = end.next.next;
            mid =mid.next;
        }
        ListNode list_node =mid.next;
        TreeNode node = new TreeNode(list_node.val);

        node.right = sortedListToBST(list_node.next);

        mid.next = null;
        node.left = sortedListToBST(head);


        mid.next = list_node;

        return node;

    }

    private TreeNode createTree(List<Integer> list, int start, int end) {
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(list.get(mid));
        if (mid>start){
            node.left = createTree(list,start,mid-1);
        }
        if (mid<end){
            node.right = createTree(list,mid+1,end);
        }
        return node;
    }
}
