//https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/
import java.util.*;

public class Inorder {
        List<Integer> res = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            inorderTraversal(root , 0);
            return res;
        }

        private void inorderTraversal(TreeNode root, int i) {
            if(root == null) return;
            inorderTraversal(root.left);
            res.add(root.val);
            inorderTraversal(root.right);
        }
}
