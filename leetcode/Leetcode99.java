public class Leetcode99 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public void recoverTree(TreeNode root) {
        TreeNode smaller=null,bigger=null,last_node=new TreeNode(Integer.MIN_VALUE);
        Inorder(root,smaller,bigger,last_node);
        int temp = smaller.val;
        smaller.val = bigger.val;
        bigger.val = temp;


    }

    private void Inorder(TreeNode root, TreeNode smaller, TreeNode bigger, TreeNode last_node) {
        if (root==null) return;
        Inorder(root.left,smaller,bigger,last_node);
        if (bigger==null&&root.val<=last_node.val){
            bigger = root;
        }

        if (bigger!=null&&root.val<=last_node.val){
            smaller = root;

        }
        last_node = root;
        Inorder(root.right,smaller,bigger,last_node);

    }

    public int tracevback(Integer integer,int value){
        if (value==1){
            return 1;
        }
        integer= new Integer(integer+1);
        return tracevback(integer,value-1);
    }

    public static void main(String[] args) {
        Leetcode99 leetcode99 =  new Leetcode99();
        Integer integer = new Integer(-1);
        System.out.println(leetcode99.tracevback(integer,3));;
        System.out.println(integer.intValue());

    }


}
