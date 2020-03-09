import java.util.ArrayList;

public class Leetcode138 {

    class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
    }


    public RandomListNode copyRandomList1(RandomListNode head) {
        if (head==null)
            return null;
        RandomListNode root  = new RandomListNode(head.label);
        ArrayList<RandomListNode> list = new ArrayList<>();
        list.add(head);

        ArrayList<RandomListNode> new_list = new ArrayList<>();
        new_list.add(root);

        RandomListNode temp = head;
        RandomListNode temp_new = root;
        while (head.next!=null){
            root.next  = new RandomListNode(head.next.label);
            new_list.add(root.next);
            list.add(head.next);
            head = head.next;
            root = root.next;
        }
        root = temp_new;
        while (temp!=null){
            if (temp.random!=null)
                temp_new.random = new_list.get(list.indexOf(temp.random));
            temp = temp.next;
            temp_new = temp_new.next;

        }

        return root;
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return null;

        RandomListNode source_head = head;
        RandomListNode new_head=null;

        //next添加
        while (source_head!=null){
            new_head = new RandomListNode(source_head.label);
            new_head.next = source_head.next;
            source_head.next = new_head;
            source_head = new_head.next;
        }

        source_head = head;
        while (source_head!=null){
            if (source_head.random!=null){
                source_head.next.random = source_head.random.next;
            }
            source_head = source_head.next.next;
        }

        //进行切断
        source_head = head;
        new_head = head.next;
        RandomListNode new_head_node = head.next;
        while (source_head!=null){
            new_head_node = source_head.next;
            source_head.next = source_head.next.next;
            if (new_head_node.next!=null){
                new_head_node.next = new_head_node.next.next;
            }
            source_head = source_head.next;
        }
        return new_head;




//        if (head==null)
//            return null;
//        RandomListNode source_head = head;
//        while (source_head!=null){
//            RandomListNode root  = new RandomListNode(head.label);
//            root.next = source_head.next;
//            source_head.next = root;
//            source_head = root.next;
//        }
//
//        source_head = head;
//        while (source_head!=null){
//            source_head.next.random = source_head.random==null?null:source_head.random.next;
//            source_head = source_head.next.next;
//        }
//
//        source_head = head;
//        RandomListNode new_head = head.next;
//        RandomListNode new_head_node = new_head;
//        while (head!=null){
//            head.next = new_head_node.next;
//            if (new_head_node.next!=null){
//                new_head_node.next = new_head_node.next.next;
//            }
//            head = head.next;
//            new_head_node = new_head_node.next;
//        }
//        return new_head;

    }

}
