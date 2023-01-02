// https://leetcode.com/problems/maximum-width-of-binary-tree/description/

import java.util.*;

class MaximumWidthBT {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 1;
        Queue<GVerticalPair> qu = new LinkedList<>();
        int max = 0;
        int min = 0;
        if (root == null)
            return res;
        qu.add(new GVerticalPair(0,  root));
        while (!qu.isEmpty()) {
            Queue<GVerticalPair> qu2 = new LinkedList<>();
            while (qu.size() != 0) {
                GVerticalPair p = qu.remove();
                TreeNode node = p.node;
                int val = p.idx;
                max = Math.max(max, val);
                min = Math.min(min, val);
                if (node.left != null) {
                    qu2.add(new GVerticalPair((2*val)+1,node.left));
                }
                if (node.right != null) {
                    qu2.add(new GVerticalPair((2*val)+2,node.right));
                }
            }
            if (!qu2.isEmpty())
                qu = new LinkedList<>(qu2);
            
            res = Math.max(res, max-min+1);

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
        }
        return res;
    }
}

class GVerticalPair {

    int idx;
    TreeNode node;

    GVerticalPair(int a, TreeNode r) {
        idx = a;
        node = r;
    }
}
