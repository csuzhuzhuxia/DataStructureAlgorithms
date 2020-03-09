import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Leetcode141 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public boolean hasCycle1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){
            if (set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)
            return false;

        ListNode node_slow = head;
        ListNode node_fast = head.next;
        while (node_slow!=node_fast){
            if (node_fast==null||node_fast.next==null)
                return false;
            node_slow = node_slow.next;
            node_fast = node_fast.next.next;
        }
        return true;

//        if (head.next==null){
//            return false;
//        }
//        ListNode node_slow = head.next;
//        ListNode node_fast = head.next.next;
//        while (node_slow!=null&&node_fast!=null){
//            if (node_slow==node_fast){
//                return true;
//            }
//            node_slow = node_slow.next;
//            if (node_fast.next!=null){
//                node_fast = node_fast.next.next;
//            }else {
//                node_fast = node_fast.next;
//            }
//        }
//        return false;
    }
}
