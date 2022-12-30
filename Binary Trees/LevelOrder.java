//https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/833987740/

import java.util.*;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> sol = new ArrayList<>();
        if(root == null) return res;
        queue.add(root);
        sol.add(root.val);
        while(queue.size() !=0){
            res.add(new ArrayList<>(sol));
            List<Integer> now= new ArrayList<>(sol);
            sol = new ArrayList<>();
            while(now.size() !=0){
                TreeNode temp = queue.peek();
                if(temp.left != null) {
                    queue.add(temp.left);
                    sol.add(temp.left.val);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                    sol.add(temp.right.val);
                }
                now.remove(0);
                queue.remove();
            }
        }
        return res;
    }
}
