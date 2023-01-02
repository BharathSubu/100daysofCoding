//https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=diameter-of-binary-tree
public class DiameterOfBinaryTree {
    int res = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        findDia(root);
        return res;
    }
    int  findDia(TreeNode root){
        if(root == null) return 0;
        int Lheight = findDia(root.left);
        int Rheight = findDia(root.right);
        res = Math.max(res,Lheight+Rheight);
        return 1 + Math.max(Lheight,Rheight);
    }
}
