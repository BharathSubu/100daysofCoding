//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

import java.util.*;

public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        flat(root);
    }
    void flat(TreeNode node){
        if(node == null) return;
        TreeNode left = null;
        TreeNode right = null;
        if(node.left != null){
            left = node.left;
        }
        if(node.right != null){
            right = node.left;
        }
        if(left != null) node.right = left;
        node.left= null;
        flatten(left);
        flatten(right);

    }

}
