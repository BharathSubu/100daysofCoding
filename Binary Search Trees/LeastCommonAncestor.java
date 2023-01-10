// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

import java.util.*;

class LeastCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val) return lowestCommonAncestor(root, q, p);
        return findLCA(root, p ,q);
    }
    TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root.val >= p.val && root.val <= q.val) return root;
        if(root.left != null && (root.val > p.val && root.val > q.val )) return findLCA(root.left, p, q);

    }
}