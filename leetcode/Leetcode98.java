public class Leetcode98 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public boolean isValidBST(TreeNode root) {
        double max =(double) Integer.MAX_VALUE+1;
        double min = (double) Integer.MIN_VALUE-1;
        if (root==null){
            return true;
        }else {
            boolean result1 = trace(root.left,min,root.val);
            boolean result2 = trace(root.right,root.val,max);
            return result1||result2;
        }
    }

    private boolean trace(TreeNode root, double min,double max) {
        if (root==null){
            return true;
        }else {
            if (root.val<max&&root.val>min){
                boolean result1 = trace(root.left,min,root.val);
                boolean result2 = trace(root.right,root.val,max);
                return result1||result2;
            }else {
                return false;
            }
        }
    }
}
