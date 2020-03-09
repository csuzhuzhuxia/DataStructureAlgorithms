public class Leetcode110 {

    //definition TreeNode
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Value{
        public int value;
    }

    public boolean isBalanced(TreeNode root) {
        Value value = new Value();
        value.value = 1;
        return isBalanced(root,value);

    }

    private boolean isBalanced(TreeNode root, Value value) {
        if (root==null){
            value.value = 0;
            return true;
        }
        Value value1=new Value(),value2=new Value();
        boolean balance1 = isBalanced(root.left,value1);
        boolean balance2 = isBalanced(root.right,value2);
        if (balance1&&balance2){
            int UnBalance = Math.abs(value1.value-value2.value);
            if (UnBalance<=1){
                value.value=1+(value1.value>value2.value?value1.value:value2.value);
                return true;
            }
        }
        return false;
    }
}
