//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
import java.util.HashMap;

public class ConstructBinaryTreeFromPostorderAndInorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return  buildTree( postorder,  inorder ,  0);
    }

    int pospre = 1;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder , int res) {
        int len = preorder.length;
        TreeNode head = new TreeNode(preorder[len-1]);
        for (int i = 0; i < len; i++) {
            map.put(inorder[i],i);
        }
        pospre = preorder.length - 2;
        return buildTree(preorder,inorder,head,0,len-1);
    }
    TreeNode buildTree(int [] preorder ,int [] inorder ,TreeNode curr , int start , int end ){

        if(start >= end ) return  curr;

        int nextele = preorder[pospre];
        if(map.get(nextele) > end || map.get(nextele) < start ) return curr;

        if(map.get(nextele) > map.get(curr.val)){
            TreeNode right = new TreeNode(nextele);
            pospre--;
            curr.right = buildTree(preorder,inorder,right,map.get(curr.val)+1,end);
            // System.out.println(curr.val+" "+curr.right.val);
        }

        if(pospre < 0  ) return curr;
        nextele = preorder[pospre];
        if(map.get(nextele) > end || map.get(nextele) < start ) return curr;
        if(map.get(nextele) < map.get(curr.val)){
            TreeNode left = new TreeNode(nextele);
            pospre--;
            curr.left = buildTree(preorder,inorder,left,start,map.get(curr.val)-1);
            // System.out.println(curr.val+" "+curr.left.val);
        }
        return curr;
    }

    public static void main(String[] args) {
        int[] preorder = {9,15,7,20,3}, inorder = {9,3,15,20,7};
        ConstructBinaryTreeFromPostorderAndInorderTraversal sol = new ConstructBinaryTreeFromPostorderAndInorderTraversal();
        sol.buildTree(preorder,inorder);
    }
}
