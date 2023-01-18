// https://leetcode.com/problems/binary-search-tree-iterator/

import java.util.*;

class BSTIterator {
    
    Stack<TreeNode> st = new Stack<>();
    TreeNode curr ; 
    public BSTIterator(TreeNode root) {
        curr = root;
    }
    public int next() {
        while(curr != null){
            st.push(curr);
            curr = curr.left;
        }
        curr = st.pop();
        int ans = curr.val;
        curr = curr.right;
        return ans;
    }
    public boolean hasNext() {
        return  ( curr!=null  || !st.isEmpty());
    }
}
