//https://leetcode.com/problems/find-duplicate-subtrees/
import java.util.*;
public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
       List<TreeNode> res = new ArrayList<>();
       HashMap<String,List<TreeNode>> set = new HashMap<>();
       dfs(root,res,set);
       return res;
    }

    private String dfs(TreeNode root, List<TreeNode> res, HashMap<String,List<TreeNode>> set) {
        if(root == null) return "N";
        String str = "";
        str+=root.val+","+"L,"+dfs(root.left,res,set)+"R,"+dfs(root.right,res,set);
        if(set.containsKey(str) && set.get(str).size() == 1) res.add(root);
        set.putIfAbsent(str,new ArrayList<>());
        set.get(str).add(root);
        return str;
    }
}
