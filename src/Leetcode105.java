import java.util.HashMap;

public class Leetcode105 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0){
            return null;
        }
        int length = preorder.length;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i],i);
        }
        return findNode(0,preorder,0,length-1,inorder,hashMap);



    }
    private TreeNode findNode(int pre_index, int[] preorder, int inorder_start, int inorder_end,int[] inorder, HashMap<Integer, Integer> hashMap) {
        TreeNode node = new TreeNode(preorder[pre_index]);
        int inorder_index = hashMap.get(node.val);
        if (inorder_index>inorder_start){
            node.left = findNode(pre_index+1,preorder,inorder_start,inorder_index-1,inorder,hashMap);
        }
        if (inorder_index<inorder_end){
            node.right = findNode(pre_index+(inorder_index-inorder_start)+1,preorder,inorder_index+1,inorder_end,inorder,hashMap);
        }
        return node;
    }
}
