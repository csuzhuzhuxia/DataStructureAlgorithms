public class Leetcode82 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {


//        if (head==null||head.next==null){
//            return head;
//        }
//        ListNode new_head = new ListNode(-1);
//        new_head.next = head;
//
//        ListNode pre = new_head;
//        ListNode cur = new_head.next;
//        int  same_value = -100;
//        boolean pre_same = false;
//        while (cur!=null){
//            if ((cur.val==same_value&&pre_same)||(cur.next!=null&& cur.val==cur.next.val)){
//                same_value = cur.val;
//                pre_same = true;
//                cur = cur.next;
//                pre.next = cur;
//            }else {
//                pre_same = false;
//                pre = cur;
//                cur = cur.next;
//            }
//        }
//
//
//        return new_head.next;


        if (head==null||head.next==null)
            return head;
        ListNode new_head = new ListNode(-1);
        new_head.next = head;
        ListNode start = new_head;
        ListNode pre = new_head,cur = new_head.next,next_node = cur.next;
        while (next_node!=null){
            if ((pre==new_head||pre.val!=cur.val)&&cur.val!=next_node.val){
                start.next = cur;
                start = start.next;
                start.next = null;
            }
            pre = cur;
            cur = next_node;
            next_node = next_node.next;
        }
        if (pre==new_head||pre.val!=cur.val){
            start.next = cur;
        }
        return new_head.next;



//        if (head==null||head.next==null){
//            return head;
//        }
//        ListNode new_head = new ListNode(-1);
//        new_head.next = head;
//        ListNode start=new_head;
//        ListNode pre_node = new_head.next,cur_node =pre_node.next, next_node = cur_node.next;
//
//        while (next_node!=null){
//            if (cur_node.val!=pre_node.val&&cur_node.val!=next_node.val){
//                start.next = cur_node;
//                start = start.next;
//                start.next = null;
//            }
//            pre_node = cur_node;
//            cur_node = next_node;
//            next_node = next_node.next;
//
//        }
//        if (cur_node.val!=pre_node.val){
//            start.next = cur_node;
//        }
//        return new_head.next;
    }
}
