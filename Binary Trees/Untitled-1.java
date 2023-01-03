// https://leetcode.com/problems/count-complete-tree-nodes/submissions/843575003/

class CountNodes {
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