public class Leetcode92 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head.next==null){
            return head;
        }
        ListNode new_head =new ListNode(-1);
        new_head.next = head;
        ListNode pre = new_head,cur=pre.next,next =cur.next;
        ListNode end1,first;
        int i=1;
        while (i<m) {
            pre = pre.next;
            i++;
        }
        first = pre;
        end1 = pre.next;
        cur = pre.next;
        next = cur.next;
        while (i<n){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        first.next = cur;
        end1.next = next;


        return new_head.next;


    }
}
