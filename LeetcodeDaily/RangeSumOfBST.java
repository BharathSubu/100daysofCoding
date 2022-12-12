// https://leetcode.com/problems/range-sum-of-bst/description/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class RangeSumOfBST {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        rangeSum(root, low, high);
        return sum;
    }
    void  rangeSum(TreeNode root, int low, int high) {
        if(root == null)  return;
        if(root.val <= high && root.val >=low) sum+=root.val;
        rangeSum(root.left, low, high);
        rangeSum(root.right, low, high);
    }
    public static void main(String[] args) {
        
    }
}