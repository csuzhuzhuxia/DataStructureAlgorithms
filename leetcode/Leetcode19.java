public class Leetcode19 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode new_head = new ListNode(-1);
        new_head.next = head;
        ListNode first = new_head,second = new_head;
        for (int i = 0; i < n+1; i++) {
            first = first.next;
        }
        while(first!=null){
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return new_head.next;
    }
}
