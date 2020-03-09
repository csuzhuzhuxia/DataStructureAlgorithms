public class Leetcode108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0)
            return null;

        return  createNode(nums,0,nums.length-1);
    }

    private TreeNode createNode(int[] nums, int start, int end) {
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        if (mid>start){
            node.left = createNode(nums,start,mid-1);
        }
        if (mid<end){
            node.right = createNode(nums,mid+1,end);
        }
        return node;

    }
}
