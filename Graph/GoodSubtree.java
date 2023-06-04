//https://practice.geeksforgeeks.org/problems/df12afc57250e7f6fc101aa9c272343184fe9859/1

import java.util.*;
public class GoodSubtree {
    int ans = 0;
    public  int goodSubtrees(Node root,int k)
    {
        solve(root, k);
        return ans;
    }

    HashSet<Integer> solve(Node root,int k){

        HashSet<Integer> set = new HashSet<>();
        if(root.left!= null) {
            set.addAll(solve(root.left,  k));
        }

        if(root.right!= null){
            set.addAll(solve(root.right,  k));
        }
        set.add(root.data);

        if(set.size()<= k) ans++;
        return set;
    }

    class Node{
        int data;
        Node left , right;
    }
}
