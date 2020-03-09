import java.util.Stack;

public class Leetcode173 {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();
        public BSTIterator(TreeNode root) {
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return stack.isEmpty();

        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node = stack.pop();
            int value =node.val;
            node = node.right;
            while (node!=null){
                stack.push(node);
                node = node.right;
            }


            return value;



        }
    }

}
