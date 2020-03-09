import java.util.ArrayList;
import java.util.List;

public class Leetcode95 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    //二叉搜索树的关键是 左子树< 根结点 < 右子树
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n==0){
            return res;
        }else {
            return generateTrees(1,n);
        }

    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start==end){
            res.add(new TreeNode(start));
            return res;
        }else if(start>end){
            res.add(null);
            return res;
        }


        for (int j = start; j <= end; j++) {
            List<TreeNode> res1 = generateTrees(start,j-1);
            List<TreeNode> res2 = generateTrees(j+1,end);
            for (int i = 0; i < res1.size(); i++) {
                for (int k = 0; k < res2.size(); k++) {
                    TreeNode temp = new TreeNode(j);
                    temp.left = res1.get(i);
                    temp.right = res2.get(k);
                    res.add(temp);
                }
            }

        }
        return res;
    }
}
