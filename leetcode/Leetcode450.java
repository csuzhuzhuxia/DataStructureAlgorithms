public class Leetcode450 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null)
            return null;

        if (key<root.val){
            root.left = deleteNode(root.left,key);
            return root;
        }else if (key>root.val){
            root.right = deleteNode(root.right,key);
            return root;
        }else {
            if (root.left==null){
                return root.right;
            }
            if (root.right==null){
                return root.left;
            }else {
                TreeNode successor = getMin(root.right);
                successor.left = root.left;
                successor.right = deleteMin(root.right);
                return successor;
            }

        }


    }

    private TreeNode getMin(TreeNode root) {
        if (root.left==null)
            return root.right;
        return getMin(root.left);
    }

    private TreeNode deleteMin(TreeNode root) {
        if (root==null)
            return root.right;
        root.left = deleteMin(root.left);
        return root;
    }


}
