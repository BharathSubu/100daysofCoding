// https://practice.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-a-pair-with-given-target-in-bst

import java.util.*;

class TwoSumVI
{
    boolean isTrue = false;
    public int isPairPresent(Node root, int target)
    {
        HashSet<Integer> set = new HashSet<>();
        inOrder(root,target,set);
        if(isTrue) return 1;
        return 0;
    }

    void inOrder(Node root , int target , HashSet<Integer> set){
        if(root == null) return;
        if(set.contains(target - root.data)){
            isTrue = true;
            return;
        }
        set.add(root.data);
        inOrder(root.left, target, set);
        inOrder(root.right, target, set);
    }
}