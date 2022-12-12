
// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

import java.util.*;

class MaximumDifferenceBetweenNodeandAncestor {
    // int max = Integer.MIN_VALUE;
    // public int maxAncestorDiff(TreeNode root) {
    //    List<TreeNode> Anc  =new ArrayList<>() ;
    //    traverseforAnc(root, Anc); 
    //    return max;
    // }
    // void traverseforAnc(TreeNode root , List<TreeNode> Anc){
    //     if(root == null) return;
    //     for (TreeNode anc : Anc) {
    //         max = Math.max(max, Math.abs(anc.val - root.val));
    //     } 
    //     Anc.add(root);
    //     traverseforAnc(root.left, Anc);
    //     traverseforAnc(root.right, Anc);
    //     Anc.remove(root);
    // }


    int res = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
       int max = Integer.MIN_VALUE ,  min = Integer.MAX_VALUE;
       traverseforAnc(root,  max , min); 
       return res;
    }
    void traverseforAnc(TreeNode root ,  int max , int min){
        if(root == null) {
            res =  Math.max(res,max - min);
            return;
        }
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        traverseforAnc(root.left,  max , min);
        traverseforAnc(root.right,  max , min);
    }

}