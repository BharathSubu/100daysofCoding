//https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/

import java.util.*;

public class LongestZigZagPathInABinaryTree {
    int ans = 0;
    public int longestZigZag(TreeNode root) {
        findAns(root,0,0);
        return ans;
    }

    private void findAns(TreeNode root, int step, int prev) {
        ans = Math.max(step,ans);
        if(root == null){
            return;
        }
        if(root.left!=null){
            if(prev == 0 || prev == 1) findAns(root.left,step+1,-1);
            else findAns(root.left,1,-1);
        }
        if(root.right!= null){
            if(prev == 0 || prev == -1) findAns(root.right,step+1,1);
            else findAns(root.right,1,1);
        }
    }

}

