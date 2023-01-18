import java.sql.RowId;

//https://leetcode.com/problems/validate-binary-search-tree/submissions/
public class ValidateBinarySearchTree {

    // long prev = Long.MIN_VALUE;
    // public boolean isValidBST(TreeNode root) {
    //     if(root == null )return true;
    //     return inorder(root);
    // }
    // boolean inorder(TreeNode root){
    //     if(root == null) return true;
    //     boolean res = inorder(root.left);
    //     if(res == false) return false;
    //     if(prev >= root.val) return false;
    //     prev = root.val;
    //     return inorder(root.right);
    // }
    public boolean isValidBST(TreeNode root) {
        return inRange(root,Long.MIN_VALUE , Long.MAX_VALUE);
    }
    boolean inRange(TreeNode root,long min , long max){
        if(root==null) return true;
        if(root.val >= max || root.val <= min) {
            return false;
        }
        return inRange(root.left, min, root.val ) && inRange(root.right, root.val, max);
    }
}
