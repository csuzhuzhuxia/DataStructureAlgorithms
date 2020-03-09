public class Leetcode114 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public void flatten1(TreeNode root) {
        if (root==null)
            return;
        flatten1(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;

        while (root.right!=null)
            root = root.right;
        root.right = temp;

    }


    public void flatten(TreeNode root) {
        if (root==null)
            return;
        while (root!=null){
            if (root.left!=null){
                TreeNode node = root.left;
                while (node.right!=null)
                    node = node.right;
                node.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

}
