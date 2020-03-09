import java.util.List;

public class Leetcode61 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }


    public ListNode rotateRight(ListNode head, int k) {
        ListNode listNode=head;
        if (head==null||head.next==null||k==0){
            return head;
        }
        int index=1;
        while (listNode.next!=null){
            index++;
            listNode = listNode.next;
        }

        if (k%index==0){
            return head;
        }

        listNode.next = head;
        k = index-k%index;

        for (int i = 0; i < k-1; i++) {
            head = head.next;
        }
        listNode=head.next;
        head.next=null;
        return listNode;


    }
}
