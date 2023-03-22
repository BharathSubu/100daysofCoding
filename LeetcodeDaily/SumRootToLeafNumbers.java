//https://leetcode.com/problems/sum-root-to-leaf-numbers/
import java.util.*;
public class SumRootToLeafNumbers {
        public class TreeNode {
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
        int sum = 0;
        public int sumNumbers(TreeNode root) {
            int num = 0;
            traverse(root,num);
            return sum;
        }
        void traverse(TreeNode root, int num){
            if(root.left == null && root.right == null){
                num*=10;
                num+=root.val;
                sum+=num;
                return;
            }
            num*=10;
            num+=root.val;
            if(root.left != null)
                traverse(root.left,num);
            if(root.right != null)
                traverse(root.right,num);
        }
}
