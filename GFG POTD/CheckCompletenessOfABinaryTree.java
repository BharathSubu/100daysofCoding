//https://leetcode.com/problems/check-completeness-of-a-binary-tree/
import java.util.*;
public class CheckCompletenessOfABinaryTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
         this.left = left;
         this.right = right;
      }
    }
    class Pair{
        int pos;
        TreeNode node;
        Pair(int _p , TreeNode _node){
            pos = _p;
            node = _node;
        }
    }
    public boolean isCompleteTree(TreeNode root) {
        int prev = 0;
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(1,root));
        while (!qu.isEmpty()){
            Pair parent = qu.remove();
            if(parent.pos - prev == 1){
                prev = parent.pos;
            }
            else return false;
            if(parent.node.left!=null) qu.add(new Pair(parent.pos*2,parent.node.left ));
            if(parent.node.right!=null) qu.add(new Pair((parent.pos*2) + 1,parent.node.right ));
        }
        return true;
    }
}
