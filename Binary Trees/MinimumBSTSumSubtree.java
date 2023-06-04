//https://practice.geeksforgeeks.org/problems/d064cc0468a5c2bb7817ecd7c1bc59ce25e23613/1?

public class MinimumBSTSumSubtree {
    static int ans = Integer.MAX_VALUE;
    static int max = 0;

    public static int minSubtreeSumBST(int target, Node root) {
        ans = Integer.MAX_VALUE;
        max =  0;
        inorder(root,target);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    static Pair inorder(Node root , int target){
        if(root==null) return new Pair(0,0,Integer.MIN_VALUE,Integer.MAX_VALUE,true);
        if(root.left==null && root.right==null)
        {
            max=Math.max(root.data,max);
            if(root.data == target) ans = 1;
            return new Pair(root.data,1,root.data,root.data,true);
        }
        Pair lp = inorder(root.left,target);
        Pair rp = inorder(root.right,target);
        Pair np= new Pair(lp.sum+root.data+rp.sum);

        int sum = lp.sum + rp.sum + root.data;
        np.totalNodes = lp.totalNodes + rp.totalNodes + 1;

        if(root.data>lp.max && root.data<rp.min && lp.bst && rp.bst)
        {
            max=Math.max(max,np.sum);
            np.bst=true;
        }
        else
            np.bst=false;
        np.min=Math.min(root.data,lp.min);
        np.max=Math.max(root.data,rp.max);
        if(np.sum == target && np.bst) ans = Math.min(ans,np.totalNodes);
        return np;
    }

    static class Pair{
        int sum;
        int totalNodes;
        boolean bst;
        int max , min ;
        Pair (int s)
        {
            sum=s;
        }
        Pair(int i, int j, int maxL ,int minR, boolean is){
            sum = i; totalNodes = j; bst = is; max = maxL; min = minR;
        }
    }
}
