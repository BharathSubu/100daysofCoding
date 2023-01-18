// https://leetcode.com/problems/insert-into-a-binary-search-tree/description/

import java.util.*;

public class InsertIntoABST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) {
            TreeNode node = new TreeNode(val);
            return node;
        }
        insertNode(root, val);
        return root;
    }
    void insertNode(TreeNode root,int val){
        if(root.val > val ){
            if(root.left == null){
                root.left = new TreeNode(val);
                return;
            }
            insertNode(root.left, val);
        }
        else{
            if(root.right == null){
                root.right = new TreeNode(val);
                return;
            }
            insertNode(root.right, val);
        }
    }
}
