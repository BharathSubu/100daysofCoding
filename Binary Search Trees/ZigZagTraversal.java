//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/

import java.util.*;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> sol = new ArrayList<>();
        if(root == null) return res;
        queue.add(root);
        sol.add(root.val);
        boolean flag = true;
        while(queue.size() !=0){
            flag = !flag;
            if(flag == true) {
                List<Integer> now= new ArrayList<>(sol);
                Collections.reverse(now);
                res.add(new ArrayList<>(now));
                // System.out.println("true");
            }
            else{
                res.add(new ArrayList<>(sol));
                // System.out.println("false");
            }
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
