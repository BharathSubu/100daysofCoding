// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

import java.util.*;

class LCA {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        List<TreeNode> ancP = new ArrayList<>();
//        List<TreeNode> ancQ = new ArrayList<>();
//
//        findAncestor(root, p, ancP);
//        findAncestor(root, q, ancQ);
//
//
//        return null;
//    }
//
//    boolean findAncestor(TreeNode root , TreeNode node , List<TreeNode> res){
//        if(res == null) res = new ArrayList<>();
//        if(root ==  node) return true;
//        if(root == null) return false;
//        res.add(root);
//        if(findAncestor(root.left, node, res)) {
//            return true;
//        }
//        if (findAncestor(root.right, node, res)) {
//            return true;
//        }
//        res.remove(root);
//        return false;
//    }
    //efficient method
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
        return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    //result
    if(left == null) {
        return right;
    }
    else if(right == null) {
        return left;
    }
    else { //both left and right are not null, we found our result
        return root;
    }
}

}