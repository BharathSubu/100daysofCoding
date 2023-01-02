//https://leetcode.com/problems/find-bottom-left-tree-value/description/

import java.util.*;

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        int res = root.val;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()){
            Queue<TreeNode> qu2 = new LinkedList<>();
            while (!qu.isEmpty()){
                TreeNode temp = qu.peek();
                if(temp.left!=null) qu2.add(temp.left);
                if(temp.right!=null) qu2.add(temp.right);
            }
            if(!qu2.isEmpty())
            res = qu2.peek().val;
            qu = new LinkedList<>(qu2);
        }
        return res;
    }
}
