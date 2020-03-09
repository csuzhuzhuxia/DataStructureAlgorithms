import java.util.HashMap;

public class Leetcode106 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        if (length==0) return null;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            hashMap.put(inorder[i],i);
        }
        return findNode(postorder,length-1,inorder,0,length-1,hashMap);
    }

    private TreeNode findNode(int[] postorder, int pos_start, int[] inorder, int inorder_start, int inorder_end, HashMap<Integer, Integer> hashMap) {
        TreeNode node = new TreeNode(postorder[pos_start]);
        int inorder_index = hashMap.get(node.val);
        if (inorder_index>inorder_start){
            node.left = findNode(postorder,pos_start-(inorder_end-inorder_index)-1,inorder,inorder_start,inorder_index-1,hashMap);
        }
        if (inorder_index<inorder_end){
            node.right = findNode(postorder,pos_start-1,inorder,inorder_index+1,inorder_end,hashMap);
        }
        return node;
    }
}
