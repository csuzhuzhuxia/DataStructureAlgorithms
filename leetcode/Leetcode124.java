public class Leetcode124 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    class value{
        int val=Integer.MIN_VALUE;
    }


    public int maxPathSum(TreeNode root) {
        value v = new value();
        helpMaxPathSum(root,v);
        return v.val;
    }

    private int helpMaxPathSum(TreeNode root, value v) {
        if (root==null)
            return 0;
        int left = Math.max(0,helpMaxPathSum(root.left,v));
        int right = Math.max(0,helpMaxPathSum(root.right,v));
        v.val = Math.max(v.val,left+right+root.val);
        return 0;
    }
}
