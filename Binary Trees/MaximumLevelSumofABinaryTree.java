//https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/
import java.util.*;
public class MaximumLevelSumofABinaryTree {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        int ans = root.val;
        int idx = 1;
        int level = 1;
        while(!qu.isEmpty()){
            Queue<TreeNode> qu2 = new LinkedList<>();
            int sum = 0;
            while (!qu.isEmpty()){
                TreeNode node = qu.remove();
                sum+=node.val;
                if(node.left!=null) qu2.add(node.left);
                if(node.right!=null) qu2.add(node.right);
            }
            if(sum > ans){
                ans = sum;
                idx = level;
            }
            level++;
            qu = new LinkedList<>(qu2);
        }
        return idx;
    }
}
