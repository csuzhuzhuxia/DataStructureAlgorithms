import java.util.List;

public class Leetcode25 {

    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode new_Head= new ListNode(-1);
        new_Head.next = head;
        ListNode pre,cur;
        pre = new_Head;
        cur = pre.next;
        int index =0;
        while (cur!=null){
            if (index%k==0){
                pre = getReverseSubGroup(pre,cur.next);
            }else{
                cur = cur.next;
            }
            index++;
        }
        return new_Head.next;
    }

    private ListNode getReverseSubGroup(ListNode pre, ListNode last) {
        ListNode first = pre.next;
        ListNode cur = first.next;
        while (cur!=last){
            first.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = first.next;
        }
        return first;
    }

//    }

//    private ListNode reverseSubGroup(ListNode pre, ListNode last) {
//        ListNode first,second;
//        first = pre.next;
//        second = first.next;
//
//        while (second!=last){
//            first.next = second.next;
//            second.next = pre.next;
//            pre.next = second;
//            second = first.next;
//        }
//
//        return pre;
//    }


}
