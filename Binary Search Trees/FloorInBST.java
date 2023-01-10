// https://practice.geeksforgeeks.org/problems/floor-in-bst/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=floor-in-bst

import java.util.*;


class FloorInBST {
    static int res = -1;
    public static int floor(Node root, int x) {
        res = -1;
        element( root, x);
        return res;
    }
    static void element(Node root,int x){
       if(root==null) return;
        if(root.data == x) {
            res = root.data;
            return;
        };        
        if(root.data > x)
        element(root.left, x);
        else
        {
            res = root.data;
            element(root.right, x);
        }
    }
}