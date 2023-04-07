//https://practice.geeksforgeeks.org/problems/e841e10213ddf839d51c2909f1808632a19ae0bf/1
import java.util.*;
public class BSTMaximumDifference {
    static int ans = Integer.MIN_VALUE;
    public static int maxDifferenceBST(Node root,int target)
    {
        SPair targetSum = findTarget(root,target);
        if(targetSum.sum == -1) return -1;
        ans = Integer.MIN_VALUE;
        findAns(targetSum.tree,targetSum.sum);
        return ans;
    }
    static void findAns(Node root ,int targer){
        Queue<SPair> qu = new LinkedList<>();
        qu.add(new SPair(targer,root));
        while (!qu.isEmpty()){
            SPair p = qu.remove();
            if(p.tree.left == null && p.tree.right == null)
                ans = Math.max(ans,p.sum);
            if(p.tree.left != null) qu.add(new SPair(p.sum - p.tree.left.data ,p.tree.left ));
            if(p.tree.right != null) qu.add(new SPair(p.sum - p.tree.right.data ,p.tree.right ));
        }
    }
    static SPair findTarget(Node root,int target){
        if(root == null) return new SPair(-1,null);
        if(target == root.data) return new SPair(0,root);
        if(root.data > target){
            SPair ans = findTarget(root.left,target);
            if(ans.sum == -1) return ans;
            return new SPair(root.data + ans.sum,ans.tree);
        }
        else{
            SPair ans = findTarget(root.right,target);
            if(ans.sum == -1) return ans;
            return new SPair(root.data + ans.sum,ans.tree);
        }
    }
}
class SPair{
    int sum ; Node tree;
    SPair(int s , Node t){
        sum = s;
        tree = t;
    }
}
