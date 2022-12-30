//https://leetcode.com/problems/binary-tree-preorder-traversal/description/
import java.util.*;
public class PreOrderRec {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return res;
    }

    private void preOrder(TreeNode root) {
        if(root == null) return;
        res.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}

