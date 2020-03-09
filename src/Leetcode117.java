public class Leetcode117 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {
        if (root==null)
            return;
        TreeLinkNode dump = new TreeLinkNode(0),t = dump;
        while (root!=null){

            if (root.left!=null){
                t.next = root.left;
                t = t.next;
            }

            if (root.right!=null){
                t.next = root.right;
                t = t.next;
            }

            root = root.next;
            if (root==null){
                t = dump;
                root = dump.next;
                dump.next = null;
            }
        }

    }
}
