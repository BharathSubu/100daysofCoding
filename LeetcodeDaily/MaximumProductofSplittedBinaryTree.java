// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/\

import java.util.*;

class MaximumProductofSplittedBinaryTree {
    long max = Integer.MIN_VALUE;
    long mod = 1000000007;
    public int maxProduct(TreeNode root) {
        long totalSum = calTotalsum(root);
        calMaxProduct(root,totalSum);
        max%=mod;
        return (int)max;
    }
    void calMaxProduct(TreeNode node, long totalSum){
        if(node == null) return;
        long val = ((totalSum - node.val) * node.val);
        max = Math.max(max, val);
        calMaxProduct(node.left, totalSum);
        calMaxProduct(node.right, totalSum);
    }
    long calTotalsum(TreeNode Node){
        if(Node == null) return 0;
        Node.val = (int) (Node.val + calTotalsum(Node.left) + calTotalsum(Node.right));
        return Node.val;
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