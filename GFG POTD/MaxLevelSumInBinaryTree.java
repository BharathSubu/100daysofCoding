//https://practice.geeksforgeeks.org/problems/4b7ff87c26ed23b3f63c25c611690213d44fb6aa/1
import java.util.*;
public class MaxLevelSumInBinaryTree {
    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    public int maxLevelSum(Node root) {
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        int ans = root.data;
        while(!qu.isEmpty()){
            Queue<Node> qu2 = new LinkedList<>();
            int sum = 0;
            while (!qu.isEmpty()){
                Node node = qu.remove();
                sum+=node.data;
                if(node.left!=null) qu2.add(node.left);
                if(node.right!=null) qu2.add(node.right);
            }
            ans = Math.max(ans,sum);
            qu = new LinkedList<>(qu2);
        }
        return ans;
    }
}
