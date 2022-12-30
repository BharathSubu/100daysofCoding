import java.util.ArrayList;
import java.util.List;

public class PostOrderRec {

    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return res;
    }

    private void postOrder(TreeNode root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        res.add(root.val);
    }
}
