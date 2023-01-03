//https://practice.geeksforgeeks.org/problems/construct-tree-1/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=construct-tree
import java.util.*;

class BtFromInorderAndPreOrder
{
    static HashMap<Integer,Integer> map ;
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {

            map.put(inorder[i],i);
        }
        Node root = buildTree(inorder,0,n,preorder,0,n);
        return root;
    }
    static Node buildTree( int inorder[] , int iStart , int iEnd , int preorder[] , int pStart , int pEnd ){
        if(pStart > pEnd || iStart > iEnd) return null;
        Node root = new Node(preorder[pStart]);
        int iIdx = map.get(root.data);
        int newLen = iIdx - iStart;
        root.left = buildTree(inorder,iStart , iIdx - 1 ,preorder , pStart + 1 ,pStart+newLen);
        root.left = buildTree(inorder,iIdx + 1,iEnd ,preorder , pStart+newLen+1 , pEnd);
        return root;
    }

}