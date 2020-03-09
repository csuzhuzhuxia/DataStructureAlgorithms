import java.util.*;

public class leetcode144 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root==null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            res.add(root.val);
            if (root.left!=null)
                stack.push(root.left);
            if (root.right!=null)
                stack.push(root.right);
        }
        return res;
    }
}
