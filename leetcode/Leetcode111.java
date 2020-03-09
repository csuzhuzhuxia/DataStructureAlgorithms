public class Leetcode111 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        if (root==null)
            return 0;

        if (root.left==null&&root.right==null)
            return 1;

        int minLeft = minDepth(root.left);
        if (minLeft==0)
            minLeft=Integer.MAX_VALUE;

        int minRight = minDepth(root.right);
        if (minRight==0)
            minRight=Integer.MAX_VALUE;

        return 1+Math.min(minLeft,minRight);
    }
}
