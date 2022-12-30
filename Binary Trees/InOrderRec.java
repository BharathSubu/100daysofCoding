//https://leetcode.com/problems/binary-tree-inorder-traversal/
import java.util.*;
public class InOrderRec {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
    }
}
