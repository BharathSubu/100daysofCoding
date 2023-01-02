//https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=level-order-traversal-in-spiral-formpublic

import  java.util.*;

public class LevelOrderSpiral {
    ArrayList<Integer> findSpiral(Node root)
    {

        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> qu = new LinkedList<>();
        boolean isRevers = true;
        if(root == null) return res;
        qu.add(root);
        while (!qu.isEmpty()){
            ArrayList<Integer> lst = new ArrayList<>();
            Queue<Node> qu2 = new LinkedList<>();
            while(qu.size()!=0){
                Node node = qu.remove();
                lst.add(node.data);
                if(node.left!= null) {
                    qu2.add(node.left);
                }
                if(node.right!= null) {
                    qu2.add(node.right);
                }
                
            }
            if(!qu2.isEmpty())
                qu = new LinkedList<>(qu2);
            if(isRevers){
                Collections.reverse(lst);
            }
            isRevers = !isRevers;
            res.addAll(lst);
        }
        return  res;
    }
}
