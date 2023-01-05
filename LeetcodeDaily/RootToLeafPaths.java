//https://practice.geeksforgeeks.org/problems/root-to-leaf-paths/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=root-to-leaf-paths


import java.util.*;

public class RootToLeafPaths {
    public ArrayList<ArrayList<Integer>> Paths(Node root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> r = new ArrayList<>();
        traverse(root,r,res);
        return res;
    }

    private void traverse(Node root, ArrayList<Integer> r, ArrayList<ArrayList<Integer>> res) {
        if(root == null){
            return;
        }
        r.add(root.data);
        if(root.left == null && root.right == null){
            ArrayList<Integer> sol = new ArrayList<>(r);
            res.add(sol);
            r.remove(r.size()-1);
            return;
        }

        traverse(root.left,r,res);
        traverse(root.right,r,res);

        r.remove(r.size()-1);
    }
}
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}