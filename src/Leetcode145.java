import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Leetcode145 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack= new Stack<>();
        if (root==null)
            return res;
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            res.add(0,root.val);
            if (root.right!=null)
                stack.push(root.right);
            if (root.left!=null)
                stack.push(root.left);
        }
        return res;
    }
}
