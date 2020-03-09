public class Leetcode143 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void reorderList(ListNode head) {
        if (head==null||head.next==null)
            return;

        ListNode slow = head,fast = head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode end =new ListNode(-1);

        if (fast.next==null){
            fast.next = end;
        }else {
            fast.next.next = end;
        }

        ListNode pre = slow;
        ListNode first = slow.next;
        ListNode cur = first.next;
        while (cur!=end){
            first.next = cur.next;
            cur.next = pre.next;

            pre.next = cur;
            cur = first.next;
        }


        first.next = null;

        ListNode node = pre.next;
        pre.next = null;


        ListNode temp = null;

        while (node!=null){
            temp = node.next;
            node.next = head.next;
            head.next = node;
            head = node.next;
            node = temp;
        }




//        if (head==null||head.next==null)
//            return;
//        ListNode node_low = head;
//        ListNode node_fast= head;
//        while (node_fast.next!=null&&node_fast.next.next!=null){
//            node_low = node_low.next;
//            node_fast = node_fast.next.next;
//        }
//
//        ListNode pre = node_low.next;
//        ListNode next = pre.next;
//        ListNode next_next = null;
//        while (next!=null){
//            next_next = next.next;
//            next.next = pre;
//            pre = next;
//            next = next_next;
//        }
//
//        ListNode node_new_next = pre;
//        ListNode new_list = head;
//        ListNode temp = null;
//        if (node_low.next!=null){
//            node_low.next.next = null;
//            node_low.next = null;
//        }
//
//        while (node_new_next!=null){
//            System.out.println(head.val);
//            temp = head.next;
//            head.next =node_new_next;
//            node_new_next = node_new_next.next;
//            head.next.next = temp;
//            head = temp;
//        }
//        head = new_list;

    }
}
