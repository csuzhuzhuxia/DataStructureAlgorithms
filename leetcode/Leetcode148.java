import java.util.List;

public class Leetcode148 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode sortList(ListNode head) {
        return head==null?null:mergesort(head);

    }

    private ListNode mergesort(ListNode head) {
        if (head.next==null){
            return head;
        }
        ListNode node_slow = head;
        ListNode node_fast = head;
        ListNode pre = null;
        while (node_fast.next!=null&&node_fast.next.next!=null){
            pre = node_slow;
            node_slow = node_slow.next;
            node_fast = node_fast.next.next;
        }
        pre.next = null;
        ListNode pre_head = mergesort(head);
        ListNode next = mergesort(node_slow);
        return merge(pre_head,next);
    }

    private ListNode merge(ListNode pre_head, ListNode next) {

        ListNode res = new ListNode(-1);
        ListNode head = res;

        while (pre_head!=null&&next!=null){
            if (pre_head.val<next.val){
                res.next = pre_head;
                res = res.next;
                pre_head = pre_head.next;
            }else {
                res.next = next;
                res = res.next;
                next = next.next;
            }
        }
        if (pre_head!=null){
            res.next = pre_head;
        }
        if (next!=null)
            res.next = next;
        return head.next;

    }


}