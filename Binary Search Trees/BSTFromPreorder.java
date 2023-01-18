// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

class BSTFromPreorder {
    int pos = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length == 1) return root;
        pos = 1;
        construct(root,Integer.MIN_VALUE , Integer.MAX_VALUE,preorder);        
        return root;
    }
    void construct (TreeNode root , int min ,int max , int[] preorder){
        if(pos == preorder.length) return;
        // System.out.println(preorder[pos]+ ""+(preorder[pos] >= max || preorder[pos] <= min));
        if(preorder[pos] < root.val && (!(preorder[pos] >= max || preorder[pos] <= min) )){
            root.left = new TreeNode(preorder[pos++]);
            construct(root.left, min, root.val - 1, preorder);
        }
        if(preorder[pos] > root.val && (!(preorder[pos] >= max || preorder[pos] <= min) )){
            root.right = new TreeNode(preorder[pos++]);
            construct(root.right, root.val+1, max, preorder);
        }
    }
}