import com.sun.org.apache.regexp.internal.RE;

public class Leetcode83 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head==null|| head.next==null)
            return head;


        ListNode pre = head,cur = head.next;
        while (cur!=null){
            if (cur.val==pre.val){
                pre.next = cur.next;
                cur = cur.next;
            }else {
                pre = cur;
                cur = cur.next;
            }

        }
        return head;





//        if (head==null||head.next==null){
//            return head;
//        }
//
//        ListNode new_head = new ListNode(-1);
//        new_head.next = head;
//
//        ListNode pre_node = head,cur_node=pre_node.next;
//        ListNode start = pre_node;
//
//
//
//        while (cur_node!=null){
//            if (cur_node.val!=pre_node.val){
//                start.next = cur_node;
//                start = cur_node;
//            }
//
//            pre_node = cur_node;
//            cur_node = cur_node.next;
//            start.next = null;
//        }
//
//        return new_head.next;


    }
}
