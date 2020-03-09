import java.util.*;

public class Leetcode103 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null)
            return res;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int level = 0;
        while (!list.isEmpty()){
            int size = list.size();
            boolean flag = true;
            List<Integer> item = new ArrayList<>();
            while (size>0){
                if (level%2==0){
                    TreeNode node = list.remove(0);
                    item.add(node.val);

                    if (node.left!=null){
                        flag = add(list,size-1,node.left,flag);
                    }

                    if (node.right!=null){
                        flag = add(list,size-1,node.right,flag);
                    }


                }else {
                    TreeNode node = list.remove(0);
                    item.add(node.val);

                    if (node.right!=null){
                        add(list,size-1,node.right,flag);
                    }

                    if (node.left!=null){
                        add(list,size-1,node.left,flag);
                    }
                }
                size--;
            }
            level++;
            res.add(item);
        }
        return res;

    }

    public boolean add(LinkedList<TreeNode> list,int index,TreeNode node,boolean isFirst){
        if (isFirst){
            list.add(node);
        }else {
            list.add(index,node);
        }
        return false;

    }


    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(4);
        list.add(list.size()-1,5);
        list.add(list.size()-1,9);
        list.add(list.size(),8);
        System.out.println(33);

    }
}
