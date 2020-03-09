import java.util.List;

public class Leetcode21 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while ((l1!=null)&&(l2!=null)){
            int value1 = l1.val;
            int value2 = l2.val;
            if (value1<value2){
                node.next = l1;
                node = node.next;
                l1 = l1.next;
            }else{
                node.next = l2;
                node = node.next;
                l2 = l2.next;
            }
        }
        if (l1!=null){
            node.next = l1;
        }
        if(l2!=null){
            node.next = l2;
        }
        return head.next;

    }
}
