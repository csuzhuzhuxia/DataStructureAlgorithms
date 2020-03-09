import java.util.*;

public class Leetcode199 {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        if(root==null)
            return null;
        List<Integer> res =new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty())
        {
            int num = nodes.size();
            for(int i=0;i<num;i++){
                TreeNode item = nodes.poll();
                if(i==num-1){
                    res.add(item.val);
                }
                if(item.left!=null)
                {
                    System.out.print(item.left.val);
                    nodes.add(item.left);
                }
                if(item.right!=null)
                {
                    System.out.print(item.right.val);
                    nodes.add(item.right);
                }

            }
        }
        return res;


    }
}
