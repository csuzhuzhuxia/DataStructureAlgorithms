public class Leetcode147 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }



    public ListNode insertionSortList(ListNode head) {
        if (head==null||head.next==null)
            return head;

        ListNode new_Head = new ListNode(-1);
        new_Head.next = head;
        ListNode node= head.next;
        ListNode next_node = null;
        while (node!=null){
            next_node =node.next;
            System.out.println(new_Head.val);
            insert(node,new_Head);
            node = next_node;
        }
        return new_Head.next;

    }

    private void insert(ListNode next, ListNode head) {
        ListNode next_next = next.next;
        while (head.next!=next){
            if (head.next.val>next.val){
                next.next = head.next;
                head.next =next;
                head = next;
                while (next.next!=next){
                    head = head.next;
                }
                head.next = next_next;
                return;
            }else
                head = head.next;
        }
    }
}
