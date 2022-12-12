// https://practice.geeksforgeeks.org/problems/maximum-difference-between-node-and-its-ancestor/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

class MaximumDifferenceBetweenNodeAndItsAncestor
{

    int res = Integer.MIN_VALUE;
    public int maxDiff(Node root) {
       traverseforAnc(root); 
       return res;
    }
    int traverseforAnc(Node root ){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        int lftmin = traverseforAnc(root.left);
        int rgtmin = traverseforAnc(root.right);
        res  = Math.max(res, root.data - Math.min(lftmin,rgtmin));
        return Math.min(root.data , Math.min(lftmin,rgtmin));
    }
}
class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}