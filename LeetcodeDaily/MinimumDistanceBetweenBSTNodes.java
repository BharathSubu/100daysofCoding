//https://leetcode.com/problems/minimum-distance-between-bst-nodes/
import java.util.*;
public class MinimumDistanceBetweenBSTNodes {
    int min = Integer.MAX_VALUE;
    TreeNode previous = null;
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return min;
    }

    public void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        if(previous!=null){
            min = Math.min(min, root.val-previous.val);
        }
        previous = root;
        inOrder(root.right);
    }
}
