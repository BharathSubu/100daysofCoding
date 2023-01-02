//https://leetcode.com/problems/count-complete-tree-nodes/description/
//class TreeNode {
//      int val;
//     TreeNode left;
//     TreeNode right;
//      TreeNode() {}
//      TreeNode(int val) { this.val = val; }
//      TreeNode(int val, TreeNode left, TreeNode right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
// }

public class CountCompleteTreeNodes {
    int count = 0;
    public int countNodes(TreeNode root) {
        inorder(root);
        return count;
    }
    void inorder(TreeNode root){
        if(root==null) return;
        count++;
        inorder(root.left);
        inorder(root.right);
    }
}
