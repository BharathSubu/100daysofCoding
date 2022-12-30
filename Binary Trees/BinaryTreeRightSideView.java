//https://leetcode.com/problems/binary-tree-right-side-view/description/

import java.util.*;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> sol = new ArrayList<>();
        if(root == null) return res;
        queue.add(root);
        sol.add(root.val);
        while(queue.size() !=0){
            res.add(sol.get(sol.size() - 1));
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
