//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        boolean isRevers = false;
        if(root == null) return res;
        qu.add(root);
        while (!qu.isEmpty()){
            List<Integer> lst = new ArrayList<>();
            Queue<TreeNode> qu2 = new LinkedList<>();
            while(qu.size()!=0){
                TreeNode node = qu.remove();
                lst.add(node.val);
                System.out.println(node.val);
                if(node.left!= null) {
                    qu2.add(node.left);
                }
                if(node.right!= null) {
                    qu2.add(node.right);
                }

            }
            if(!qu2.isEmpty())
                qu = new LinkedList<>(qu2);
            if(isRevers){
                Collections.reverse(lst);
            }
            isRevers = !isRevers;
            res.add(lst);
        }
        return  res;
    }

    public static void main(String[] args) {
        TreeNode rootl = new TreeNode(10);
        TreeNode rootr = new TreeNode(20);
        TreeNode root = new TreeNode(5,rootl,rootr);
        System.out.println(zigzagLevelOrder(root));
    }
}
