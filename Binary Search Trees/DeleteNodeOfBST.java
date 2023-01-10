// https://leetcode.com/problems/delete-node-in-a-bst/

class DeleteNodeOfBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root,key);
    }
    TreeNode delete(TreeNode root,int key){
        if(root == null) return null;
        if(root.val == key){
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            root.right = findMinOrMax(root,root.right);
            return root;
        }
        if(root.val > key) root.left = delete(root.left,key);
        else root.right = delete(root.right,key);
        return root;
    }
    TreeNode findMinOrMax(TreeNode root , TreeNode temp){
        if(temp.left == null && temp.right != null){
            root.val = temp.val;
            return temp.right;
        }
        if(temp.left == null && temp.right == null){
            root.val = temp.val;
            return null;
        }
        if(temp.left!=null) temp.left = findMinOrMax(root,temp.left);
        return temp;
    }
}