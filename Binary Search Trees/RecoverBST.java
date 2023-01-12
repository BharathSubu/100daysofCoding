//https://leetcode.com/problems/recover-binary-search-tree/
public class RecoverBST {
    TreeNode first = null;
    TreeNode last = null;
    TreeNode prev = null;
    TreeNode middle = null;
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first!=null && middle!=null){
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
        if(first!=null && last!=null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(prev != null && root.val < prev.val){
            if(first == null){
                first = prev;
                middle = root;
            }
            else last = root;
        }
        prev = root;
        inorder(root.right);
    }
}
