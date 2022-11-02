//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    int pospre = 1;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        TreeNode head = new TreeNode(preorder[0]);
        for (int i = 0; i < len; i++) {
            map.put(inorder[i],i);
        }
        return buildTree(preorder,inorder,head,0,len-1);
    }
    TreeNode buildTree(int [] preorder ,int [] inorder ,TreeNode curr , int start , int end ){

        if(start >= end ) return  curr;

        int nextele = preorder[pospre];
        if(map.get(nextele) > end || map.get(nextele) < start ) return curr;

        if(map.get(nextele) < map.get(curr.val)){
            TreeNode left = new TreeNode(nextele);
            pospre++;
            curr.left = buildTree(preorder,inorder,left,start,map.get(curr.val)-1);
            System.out.println(curr.val+" "+curr.left.val);
        }
        if(pospre > preorder.length - 1  ) return curr;
        nextele = preorder[pospre];
        if(map.get(nextele) > end || map.get(nextele) < start ) return curr;
        if(map.get(nextele) > map.get(curr.val)){
            TreeNode right = new TreeNode(nextele);
            pospre++;
            curr.right = buildTree(preorder,inorder,right,map.get(curr.val)+1,end);
            System.out.println(curr.val+" "+curr.right.val);
        }
        return curr;
    }

    public static void main(String[] args) {
      int[] preorder = {3,2,1,4}, inorder = {1,2,3,4};
      ConstructBinaryTreeFromPreorderAndInorderTraversal sol = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
      sol.buildTree(preorder,inorder);
    }
}
