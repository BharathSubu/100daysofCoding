//https://practice.geeksforgeeks.org/problems/c85e3a573a7de6dfd18398def16d05387852b319/1

import java.util.*;

public class BSTDownwardTraversal {
    long verticallyDownBST(Node root,int target)
    {
        root = findNode(root, target);
        if(root == null) return -1;
        return verticalTraversal(root,target);
    }
    Node findNode(Node root , int target){
        if(root == null) return null;
        if(root.data == target) return root;
        if(root.data > target && root.left != null) {
            Node ans = findNode(root.left,target);
            if(ans!= null) return ans;
        }
        if(root.data < target && root.right != null) {
            return findNode(root.right,target);
        }
        return null;
    }
    class Pair{
        Node node; long x, y;
        Pair(Node n,long _x , long _y){
            node = n;
            y = _y;
            x = _x;
        }
    }
    long verticalTraversal(Node root,int target)
    {
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(root,0,0));
        int sum = 0 ;long ansCordX = -1 , ansCordY = -1 , ansPrev = -1;
        boolean isFound = false;
        while (!qu.isEmpty()){
            Pair p = qu.remove();
            Node parent = p.node;
            long cordX = p.x;
            long cordY = p.y;
            if(isFound && cordX != ansCordX && cordY == ansCordY  ){
                sum+=parent.data;
            }
            if(parent.left!=null) qu.add(new Pair(parent.left,cordX-1 ,cordY-1));
            if(parent.right!=null) qu.add(new Pair(parent.right,cordX-1,cordY+1));
            if(parent.data == target) {
                isFound = true;
                ansCordX = cordX;
                ansCordY = cordY;
            }
        }
        if(isFound) return sum;
        return -1;
    }
}
