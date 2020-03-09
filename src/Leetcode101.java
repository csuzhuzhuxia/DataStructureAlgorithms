import java.util.LinkedList;
import java.util.Queue;

public class Leetcode101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root==null){
            return true;
        }
        return isSame(root.left,root.right);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if (left==null&&right==null){
            return true;
        }else if(left==null||right==null){
            return false;
        }else {
            if (left.val==right.val){
                return isSame(left.left,right.right)&&isSame(left.right,right.left);
            }else{
                return false;
            }
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root==null)
            return true;

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        nodes.add(root);
        TreeNode left,right;
        while (!nodes.isEmpty()) {
            left = nodes.poll();
            right = nodes.poll();
            if (left==null&&right==null)
                continue;
            else if (left==null||right==null){
                return false;
            }else if (left.val!=right.val){
                return false;
            }else {
                nodes.add(left.left);
                nodes.add(right.right);
                nodes.add(left.right);
                nodes.add(right.left);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(null);
        System.out.println(nodes.isEmpty());
    }
}
