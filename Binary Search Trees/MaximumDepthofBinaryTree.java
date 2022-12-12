// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

import java.util.*;

class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null ) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}