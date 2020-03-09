import java.util.ArrayList;

public class Leetcode86 {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode partition1(ListNode head, int x) {
        ListNode new_head = new ListNode(-1);
        new_head.next = head;
        ListNode start;
        start = new_head;
        ArrayList<ListNode> nodes = new ArrayList<>();
        while (head!=null){
            if (head.val<x){
                new_head.next = head;
                new_head = head;
                head = head.next;
            }else {
                nodes.add(head);
                head = head.next;
            }
        }
        if (!nodes.isEmpty()){
            for (int i = 0; i < nodes.size(); i++) {
                new_head.next = nodes.get(i);
                new_head = new_head.next;
            }
            new_head.next = null;
        }
        return start.next;
    }
    public ListNode partition(ListNode head, int x) {
        ListNode head1,head2,head1_start,head2_start;
        head1 = new ListNode(-1);
        head2 = new ListNode(-2);
        head2_start = head2;
        head1_start = head1;

        while (head!=null){
            if (head.val<x){
                head1.next = head;
                head1 = head1.next;
            }else {
                head2.next = head;
                head2 =head2.next;
            }
            head = head.next;
        }
        head1.next = head2_start.next;
        return head1_start.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode next = head;
        next = next.next;
        next = new ListNode(8);


    }
}
