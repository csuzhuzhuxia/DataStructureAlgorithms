import java.util.*;

public class Leetcode94 {

    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal1(TreeNode root) {



//        List<Integer> res = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        while (root!=null||!stack.isEmpty()){
//            if (root!=null){
//                stack.push(root);
//                root = root.left;
//            }else {
//                root = stack.pop();
//                res.add(root.val);
//                root = root.right;
//            }
//        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack =new Stack<>();
        while (root!=null&&!stack.isEmpty()){
            if (root!=null){
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;

    }


    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root,prev = null;
        while (cur!=null){
            if (cur.left==null){
                res.add(cur.val);
                cur = cur.right;
            }else {
                prev = cur.left;
                while (prev.right!=null&&prev.right!=cur){
                    prev = prev.right;
                }
                if (prev.right==null){
                    prev.right = cur;
                    cur = cur.left;
                }
                if (prev.right==cur){
                    prev.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
