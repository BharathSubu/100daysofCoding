// https://leetcode.com/problems/leaf-similar-trees/
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
import java.util.*;

import javax.swing.plaf.TreeUI;

class LeafSimilarTrees {

    Queue<Integer> queue = new LinkedList<Integer>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        preorder(root1);
        boolean res = checkpreorder(root2);
        if(res &&  queue.isEmpty()) return true;
        return false;
    }

    void preorder(TreeNode head){
        if(head == null) return;
        if(head.left == null && head.right == null) queue.add(head.val);
        preorder(head.left);
        preorder(head.right);
    }

    boolean checkpreorder(TreeNode head){
        if(head == null) return true;
        if(head.left == null && head.right == null) {
            if(queue.isEmpty())return false;
            if(head.val == queue.remove()) return true;
            return false;
        }
        boolean first = checkpreorder(head.left);
        if(first) return checkpreorder(head.right);
        return false;
    }
    
}