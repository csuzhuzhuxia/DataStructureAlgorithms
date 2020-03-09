import java.util.ArrayList;
import java.util.List;

public class Leetcode129 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    public int sumNumbers(TreeNode root) {
        if (root==null){
            return 0;
        }
        List<Character> nums = new ArrayList<>();
        int res =0;
        return sumNumbersTrace(root,nums);

    }

    private int sumNumbersTrace(TreeNode root, List<Character> nums) {
        nums.add((char)root.val);

        if (root.left==null&&root.right==null){
            int value = 0;
            for (int i = 0; i < nums.size(); i++) {
                value = value*10+nums.get(i);
            }
            return value;
        }
        int value_left = 0,value_rigth=0;
        if (root.left!=null){
            value_left = sumNumbersTrace(root.left,nums);
        }

        if (root.right!=null){
            value_rigth = sumNumbersTrace(root.right,nums);
        }

        nums.remove(nums.size()-1);

        return value_left+value_rigth;






    }
}
