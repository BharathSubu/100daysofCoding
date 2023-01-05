//https://leetcode.com/problems/binary-tree-maximum-path-sum/

import java.util.*;

public class MaximumPathSum {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findmax(root);
        return res;
    }
    int findmax(TreeNode root){
        if(root == null) return 0;
        int lft = findmax(root.left);
        int rgt = findmax(root.right);
        int sum = root.val;
        if(lft > 0) sum+=lft;
        if(rgt > 0) sum+=rgt;
        res = Math.max(res , sum);
        int send = root.val;
        if(lft > 0 || rgt > 0)
            return Math.max(send+lft , send+rgt);
        return send;
    }
}
