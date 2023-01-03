//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBinaryTree {
    public void flatten(TreeNode root) {
        flat(root);
    }
    TreeNode prev = null;
    void flat(TreeNode root){
        // inorder(root);
        if(root == null) return;

        flat(root.right);
        flat(root.left);

        root.left = null;
        root.right = prev;

        prev = root;
    }

}
