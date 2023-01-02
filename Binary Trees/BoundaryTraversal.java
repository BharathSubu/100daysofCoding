
//https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=boundary-traversal-of-binary-tree

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class BoundaryTraversal {
    ArrayList <Integer> boundary(Node node)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(!isLeaf(node)) res.add(node.data);
        addLeftBoundary(node,res);
        addLeaves(node,res);
        addRightBoundart(node,res);
        return res;
    }

    boolean isLeaf(Node node){
        if(node.left == null && node.right == null) return true;
        return false;
    }

     void addLeftBoundary(Node node, ArrayList<Integer> res) {
        Node curr = node.left;
        while (curr!=null){
            if(!isLeaf(curr)) res.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

     void addLeaves(Node node, ArrayList<Integer> res) {
         if (isLeaf(node)) {
             res.add(node.data);
             return;
         }
         if (node.left != null) addLeaves(node.left, res);
         if (node.right != null) addLeaves(node.right, res);
    }

     void addRightBoundart(Node node, ArrayList<Integer> res) {
         Node curr = node.right;
         ArrayList<Integer> lst = new ArrayList<>();
         while (curr!=null){
             if(!isLeaf(curr)) lst.add(curr.data);
             if(curr.right != null) curr = curr.right;
             else curr = curr.left;
         }
         Collections.reverse(lst);
         res.addAll(lst);
    }
}
