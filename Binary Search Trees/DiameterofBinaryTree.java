// https://leetcode.com/problems/diameter-of-binary-tree/submissions/

class DiameterofBinaryTree {

    int res = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        findDia(root);
        return res;
    }
    int findDia(TreeNode root){
        if(root == null) return 0 ; 
        int diaL = findDia(root.left) , diaR = findDia(root.right);
        int diaAtRoot = diaL + diaR;
        res = Math.max(diaAtRoot, res);
        return 1 + Math.max(diaL,diaR);
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }