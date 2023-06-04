//https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
import java.util.*;
public class MaximumSumBSTInBinaryTree {
    int ans = 0;
    int max = 0;

    public int maxSumBST(TreeNode root) {
        inorder(root);
        return max;
    }

    Pair inorder(TreeNode root){
        if(root==null) return new Pair(0,0,Integer.MIN_VALUE,Integer.MAX_VALUE,true);
        if(root.left==null && root.right==null)
        {
            max=Math.max(root.val,max);
            return new Pair(root.val,1,root.val,root.val,true);
        }
        Pair lp = inorder(root.left);
        Pair rp = inorder(root.right);
        Pair np= new Pair(lp.sum+root.val+rp.sum);

        int sum = lp.sum + rp.sum + root.val;
        np.totalNodes = lp.totalNodes + rp.totalNodes + 1;

        if(root.val>lp.max && root.val<rp.min && lp.bst && rp.bst)
        {
            max=Math.max(max,np.sum);
            np.bst=true;
        }
        else
            np.bst=false;
        np.min=Math.min(root.val,lp.min);
        np.max=Math.max(root.val,rp.max);
        if(np.bst) max = Math.max(max,np.sum);
        return np;
    }
    class Pair{
        int sum;
        int totalNodes;
        boolean bst;
        int max , min ;
        Pair (int s)
        {
            sum=s;
        }
        Pair(int i, int j, int maxL ,int minR, boolean is){
            sum = i; totalNodes = j; bst = is; max = maxL; min = minR;
        }
    }
}
