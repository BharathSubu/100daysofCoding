//https://leetcode.com/problems/symmetric-tree/

import java.util.*;

public class SymmetricTree {
//    public boolean isSymmetric(TreeNode root) {
//        Queue<TreeNode> qu = new LinkedList<>();
//        if(root == null) return true;
//        qu.add(root);
//        while (!qu.isEmpty()){
//            ArrayList<Integer> lst = new ArrayList<>();
//            Queue<TreeNode> qu2 = new LinkedList<>();
//            while(qu.size()!=0){
//                TreeNode node = qu.remove();
//
//                if(node.left!= null) {
//                    qu2.add(node.left);
//                    lst.add(node.left.val);
//                }
//                else {
//                    lst.add(-100099);
//                }
//                if(node.right!= null) {
//                    qu2.add(node.right);
//                    lst.add(node.right.val);
//                }
//                else {
//                    lst.add(-100099);
//                }
//            }
//            qu = new LinkedList<>(qu2);
//            int i = 0 , j = lst.size() -1;
//            while (i<=j){
//                if(!lst.get(i).equals(lst.get(j))) return false;
//                i++;
//                j--;
//            }
//        }
//        return  true;
//    }


    //efficient one
    static boolean isSymmetricUtil(TreeNode  root1, TreeNode  root2) {
        if (root1 == null || root2 == null)
            return root1 == root2;
        return (root1 . val == root2 . val) && isSymmetricUtil(root1 . left, root2 .
                right) && isSymmetricUtil(root1 . right, root2 . left);
    }
    static boolean isSymmetric(TreeNode  root) {
        if (root==null) return true;
        return isSymmetricUtil(root . left, root . right);
    }
}
