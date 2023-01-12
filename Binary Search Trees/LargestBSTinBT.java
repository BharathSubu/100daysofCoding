//https://practice.geeksforgeeks.org/problems/largest-bst/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=largest-bst
public class LargestBSTinBT {
    static int largestBst(Node root)
    {
       return largestBstHelper(root).maxSize ;
    }

    static  NodeValue largestBstHelper(Node root){
        if(root == null) return  new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        NodeValue left = largestBstHelper(root.left);
        NodeValue right = largestBstHelper(root.right);

        if(left.maxNode < root.data && root.data < right.minNode){
            return  new NodeValue(Math.min(root.data, left.minNode),Math.max(root.data, right.maxNode),left.maxSize+right.maxSize+1);
        }
        return  new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.maxSize,right.maxSize));
    }
    static class NodeValue{
        int minNode ,  maxNode ,  maxSize ;
        NodeValue(int min , int max , int size){
            minNode = min;
            maxNode = max;
            maxSize = size;
        }
    }
}
