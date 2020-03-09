public class Leetcode112 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null)
            return false;
        if (root.left==null&&root.right==null){
            return sum==root.val;
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);

    }

    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root==null){
            return false;
        }
        if (root.left==null && root.right==null){
            return sum==root.val;
        }

        boolean isLeft=false;
        boolean isRight = false;

        //这种错误表现在，我们只能够计算到当其中一个为null时候，可以的
        //但是如果两个都不为null，这种就是不会考虑到
        if (root.left==null){
            isRight = hasPathSum(root.right,sum-root.val);
        }

        if (root.right==null){
            isLeft = hasPathSum(root.left,sum-root.val);
        }
        return isRight||isLeft;
    }
}
