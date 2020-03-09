import java.util.List;

public class Leetcode23 {

    class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length==0)
            return null;
        int n = lists.length;
        while (n>1){
            int i=0,j=0;
            for (; i <n-1;i+=2) {
                lists[j++] = mergeTwoLists(lists[i],lists[i+1]);
            }
            if (i==n-1){
                lists[j++] = lists[i];
            }
            n = j;
        }
        return lists[0];


//        int length = lists.length;
//        if (length==0)
//            return null;
//        int n=length;
//        while (n>1){
//            int i=0,j=0;
//            for (;i<n-1;i+=2) {
//                ListNode node = mergeTwoLists(lists[i],lists[i+1]);
//                lists[j++] = node;
//            }
//            if (i==n-1) lists[j++] = lists[i];
//            n = j;
//        }
//        return lists[0];

    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode node = head;
        while(l1!=null&&l2!=null){
            node.next = l1.val<l2.val?l1:l2;
            node = node.next;
            if(l1.val<l2.val){
                l1 =l1.next;
            }else{
                l2 = l2.next;
            }
        }
        if(l1!=null){
            node.next = l1;
        }
        if(l2!=null){
            node.next = l2;
        }

        return head.next;
    }
}
