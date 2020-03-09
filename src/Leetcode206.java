public class Leetcode206 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {

        ListNode pre = new ListNode(-1);
        pre.next = head;

        ListNode cur=head.next;

        while (cur!=null){

            head.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = cur.next;
        }
        return pre.next;




    }
}
