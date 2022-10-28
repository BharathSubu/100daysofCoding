//https://leetcode.com/problems/kth-smallest-element-in-a-bst/

public class KthSmallestElementInABst {

    int step = 0;
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return ans;
    }

    public void inorder(TreeNode head , int k){
        if(head==null) return ;
        inorder(head.left,k);
        step++;
        if(step == k){
            ans = head.val;
            return;
        }
        inorder(head.right,k);
        return ;
    }
}
