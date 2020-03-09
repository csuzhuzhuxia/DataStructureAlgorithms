public class Leetcode24 {

    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode new_head = new ListNode(0);
        new_head.next = head;
        ListNode first ,second,third;
        first = new_head;
        while (first.next!=null&&first.next.next!=null){
            second = first.next;
            third = second.next;
            first.next = third.next;
            third.next = second;
            first = third;
        }
        return new_head.next;

//        ListNode newHead =new ListNode(0);
//        newHead.next = head;
//        ListNode first,second,third;
//        first = newHead;
//
//        ListNode temp;
//        while(first.next!=null&&first.next.next!=null){
//
//            //取出第二个和第三个节点
//            second = first.next;
//            third = first.next.next;
//
//            //交换节点
//
//            second.next = third.next;
//            first.next = third;
//            third.next = second;
//
//            //进行迭代
//            first = second;
//        }
//
//        return newHead.next;
    }
}
