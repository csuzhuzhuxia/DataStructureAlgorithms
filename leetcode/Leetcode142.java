import java.util.HashMap;
import java.util.HashSet;

public class Leetcode142 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){
            if (set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }


    /*
    备注：在MeetingNode方法中，当快慢指针（slow、fast）相遇时，slow指针肯定没有遍历完链表，而fast指针已经在环内循环了n（n>=1）圈。假设slow指针走了s步，则fast指针走了2s步。同时，fast指针的步数还等于s加上在环上多转的n圈，设环长为r，则满足如下关系表达式：
        2s = s + nr;
        所以可知：s = nr;
        假设链表的头节点到“环的尾节点“的长度为L（注意，L不一定是链表长度），环的入口节点与相遇点的距离为x，链表的头节点到环入口的距离为a，则满足如下关系表达式：
        a + x = s = nr;
        可得：a + x = (n - 1)r + r = (n - 1)r + (L - a)
        进一步得：a = (n - 1)r + (L -a - x)
        结论：
        <1> (L - a -x)为相遇点到环入口节点的距离，即从相遇点开始向前移动(L -a -x)步后，会再次到达环入口节点。
        <2> 从链表的头节点到环入口节点的距离 ＝ (n - 1) * 环内循环 ＋ 相遇点到环入口点的距离。
        <3> 于是从链表头与相遇点分别设一个指针，每次各走一步，两个指针必定相遇，且相遇第一点为环入口点。
     */
    public ListNode detectCycle(ListNode head) {

        if(head==null||head.next==null)
            return null;
        ListNode node_slow = head;
        ListNode node_fast = head;
        int index = 0;
        while (index!=0&&node_slow!=node_fast){
            if (node_fast==null||node_fast.next==null){
                return null;
            }
            index=1;
            node_slow = node_slow.next;
            node_fast = node_fast.next.next;
        }

        //这个点就是相遇点
        ListNode node = head;


        while (node!=node_slow){
            node = node_fast.next;
            node_slow = node_slow.next;
        }
        return node_slow;





//        if (head==null||head.next==null)
//            return null;
//        ListNode node_slow = head.next;
//        ListNode node_fast = head.next.next;
//        int index = 1;
//        while (node_slow!=null&&node_fast!=null){
//            if (node_slow==node_fast)
//                break;
//            node_slow = node_slow.next;
//            if (node_fast.next!=null)
//                node_fast = node_fast.next.next;
//            else
//                node_fast = node_fast.next;
//            index++;
//
//        }
//        if (node_slow==null||node_fast==null){
//            return null;
//        }
//        ListNode node_detected = head;
//        while (head!=node_slow){
//            head = head.next;
//            node_slow = node_slow.next;
//        }
//        return head;


    }
}
