// https://practice.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=tree-from-postorder-and-inorder

import java.util.*;

public class BtFromInorderAndPostOrder {
    public Node buildTree(int[] inorder, int[] postorder , int n) {
        int len = postorder.length;
        Node head = new Node(postorder[len-1]);
        for (int i = 0; i < len; i++) {
            map.put(inorder[i],i);
        }
        pospre = postorder.length - 2;
        return buildTree(postorder,inorder,head,0,len-1);
    }

    int pospre = 1;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    Node buildTree(int [] postorder ,int [] inorder ,Node curr , int start , int end ){

        if(start >= end ) return  curr;

        int nextele = postorder[pospre];
        if(map.get(nextele) > end || map.get(nextele) < start ) return curr;

        if(map.get(nextele) > map.get(curr.data)){
            Node right = new Node(nextele);
            pospre--;
            curr.right = buildTree(postorder,inorder,right,map.get(curr.data)+1,end);
            // System.out.println(curr.val+" "+curr.right.val);
        }

        if(pospre < 0  ) return curr;
        nextele = postorder[pospre];
        if(map.get(nextele) > end || map.get(nextele) < start ) return curr;
        if(map.get(nextele) < map.get(curr.data)){
            Node left = new Node(nextele);
            pospre--;
            curr.left = buildTree(postorder,inorder,left,start,map.get(curr.data)-1);

        }
        return curr;
    }

    void inorder(Node node){
        if(node == null)  return;
        inorder(node.left);
        System.out.println(node.data);
        inorder(node.right);
    }
    public static void main(String[] args) {
        int n = 8;
int in[] = { 4,8,2,5,1,6,3,7};
int post [] = {8,4,5,2,6,7,3,1};
        BtFromInorderAndPostOrder sol = new BtFromInorderAndPostOrder();
        Node root = sol.buildTree(in, post, n);
        sol.inorder(root);
    }

}
