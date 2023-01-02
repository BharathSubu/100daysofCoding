//https://leetcode.com/problems/balanced-binary-tree/description/
public class BalancedBinaryTree {
    boolean isTrue = true;
    public boolean isBalanced(TreeNode root) {
        isEqual(root);
        return isTrue;
    }
    int  isEqual(TreeNode root){
        if(!isTrue) return 0;
        if(root == null) return 0;
        int Lheight = isEqual(root.left);
        int Rheight = isEqual(root.right);
        if(Math.abs(Lheight - Rheight) > 1) {
            isTrue = false;
        }
        return 1 + Math.max(Lheight,Rheight);
    }

}
