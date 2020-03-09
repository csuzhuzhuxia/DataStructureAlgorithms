import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.Queue;

public class TEST {

    public boolean isSAME(TreeNode left, TreeNode right) {
        if (left==null&&right==null){
            return true;
        }if (left==null||right==null)
            return false;
        if (left.val==right.val){
            return isSAME(left.left,right.right)&&isSAME(left.right,right.left);
        }
        return false;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int getMax(TreeNode root){
        int max = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            int size = nodes.size();
            max = Math.max(size,max);
            for (int i = 0; i < size; i++) {
                root = nodes.poll();
                if (root.left!= null)
                    nodes.add(root.left);
                if (root.right!=null)
                    nodes.add(root.right);
            }
        }
        return max;
    }

    public boolean getSame(TreeNode root){
        if (root==null)
            return true;
        return isSAME(root.left,root.right);
    }


    public TreeNode getMirror(TreeNode root){
        if (root==null)
            return null;
        TreeNode new_root = new TreeNode(root.val);

        TreeNode left = getMirror(root.left);
        TreeNode right = getMirror(root.right);

        new_root.left = right;
        new_root.right = left;
        return new_root;

    }




}
