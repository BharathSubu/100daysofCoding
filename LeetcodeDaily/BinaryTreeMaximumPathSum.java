import java.sql.RowId;

class BinaryTreeMaximumPathSum {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return res;
    }

    int findMax(TreeNode root){
        if(root == null) return 0;
        int lftsum = findMax(root.left);
        int rgtsum = findMax(root.right);
        int sum = root.val;
        if(lftsum > 0) sum+=lftsum;
        if(rgtsum > 0) sum+=rgtsum;
        res = Math.max(res, sum);
        res = Math.max(res, root.val);
        return sum;
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