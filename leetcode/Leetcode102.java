import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<TreeNode> nodes_next = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            List<Integer> item = new ArrayList<>();
            while (!nodes.isEmpty()){
                TreeNode node = nodes.poll();
                if (node!=null){
                    item.add(node.val);
                    nodes_next.add(node.left);
                    nodes_next.add(node.right);
                }
            }
            if (!item.isEmpty()){
                res.add(item);
                Queue<TreeNode> node_temp = nodes;
                nodes = nodes_next;
                nodes_next = node_temp;
            }

        }
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            List<Integer> item = new ArrayList<>();
            int size = nodes.size();
            while (size>0){
                TreeNode node = nodes.poll();
                item.add(node.val);
                if (node.left!=null)
                    nodes.add(node.left);
                if (node.right!=null)
                    nodes.add(node.right);
                size--;
            }
            res.add(item);
        }
        return res;
    }
}
