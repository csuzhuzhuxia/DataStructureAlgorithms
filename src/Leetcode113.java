import java.util.ArrayList;
import java.util.List;

public class Leetcode113 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        List<Integer> item = new ArrayList<>();
        traceback(root,item,res,sum);
        return res;
    }

    private void traceback(TreeNode root, List<Integer> item, List<List<Integer>> res, int sum) {
        if (root==null){
            return;
        }
        item.add(root.val);
        if (root.left==null&&root.right==null&&root.val==sum){
                List<Integer> item_new = new ArrayList<>();
                for (Integer integer:item) {
                    item_new.add(integer);
                }
                res.add(item_new);
        }

        traceback(root.left,item,res,sum-root.val);
        traceback(root.right,item,res,sum-root.val);
        //这种表现在，我们可以删除的整数是有重复，此时我们删除的就不一定了，所以要指定我们的索引
        item.remove(item.size()-1);

    }


}
