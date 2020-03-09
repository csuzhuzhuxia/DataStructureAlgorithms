import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode116 {

    public class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void connect1(TreeLinkNode root) {
        if (root==null)
            return;
        Queue<TreeLinkNode> queues  = new LinkedList<>();
        queues.add(root);
        while (!queues.isEmpty()){
            int size = queues.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode node = queues.poll();
                if (node.left!=null)
                    queues.add(node.left);
                if (node.right!=null)
                    queues.add(node.right);
                if (i==size-1){
                    node.next = null;
                }else {
                    node.next = queues.peek();
                }
            }
        }
    }

    public void connect(TreeLinkNode root) {
        if (root==null||root.left==null)
            return;
        TreeLinkNode start = root;
        while (start.left!=null){
            TreeLinkNode cur = start;
            while (cur!=null){
                cur.left.next = cur.right;
                if (cur.next!=null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            start = start.left;
        }


    }
}
