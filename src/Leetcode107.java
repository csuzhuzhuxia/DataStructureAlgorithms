import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode107 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root==null)
            return res;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            int size = nodes.size();
            List<Integer> integers = new ArrayList<>();
            while (size>0){
                TreeNode node = nodes.poll();
                integers.add(node.val);
                if (node.left!=null){
                    nodes.add(node.left);
                }
                if (node.right!=null){
                    nodes.add(node.right);
                }
                size--;
            }
            res.add(0,integers);
        }
        return res;

    }


    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0,1);
    }
}
