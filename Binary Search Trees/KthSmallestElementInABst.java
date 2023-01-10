//https://leetcode.com/problems/kth-smallest-element-in-a-bst/

public class KthSmallestElementInABst {
    int res = -1;
    int step = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return res;
    }
    void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(step==k){
            res = root.val;
            return;
        }
        inorder(root.right);
        
    }
}
