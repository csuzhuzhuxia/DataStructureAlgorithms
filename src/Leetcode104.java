import java.util.LinkedList;
import java.util.Queue;

public class Leetcode104 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public int maxDepth1(TreeNode root) {
        if (root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    public int maxDepth(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        if (root==null){
            return 0;
        }
        nodes.add(root);
        int level=0;
        while(!nodes.isEmpty()){
            int size = nodes.size();
            while (size>0){
                TreeNode node =nodes.poll();
                if (node.left!=null)
                    nodes.add(node.left);
                if (node.right!=null)
                    nodes.add(node.right);
                size--;
            }
            level++;
        }
        return level;
    }
}
