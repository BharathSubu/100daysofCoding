//https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bottom-view-of-binary-tree

import java.util.*;

public class BottomViewOfBT {
    public ArrayList <Integer> bottomView(Node root)
    {
            ArrayList<Integer> res = new ArrayList<>();
            Queue<TVerticalPair> qu = new LinkedList<>();
            int max = 0;
            int min = 0;
            HashMap<Integer,List<Integer>> map = new HashMap<>();
            if(root == null) return res;
            int level =0;
            qu.add(new TVerticalPair(0,level,root));
            while (!qu.isEmpty()){
                Queue<TVerticalPair> qu2 = new LinkedList<>();
                level++;
                List<Integer> levelEle = new ArrayList<>();
                while(qu.size()!=0){
                    TVerticalPair p = qu.remove();
                    Node node = p.node;
                    int val = p.xcord;
                    max = Math.max(max,val);
                    min = Math.min(min,val);
                    map.putIfAbsent(val,new ArrayList<>());
                    map.get(val).add(node.data);
//                System.out.println(node.val);
                    if(node.left!= null) {
                        qu2.add(new TVerticalPair(val-1,level,node.left));
                    }
                    if(node.right!= null) {
                        qu2.add(new TVerticalPair(val+1,level,node.right));
                    }
                }
                if(!qu2.isEmpty())
                    qu = new LinkedList<>(qu2);
            }

            for (int i = min; i < max+1; i++) {
                List<Integer> r = new ArrayList<>(map.get(i));
                res.add(r.get(r.size()-1));
            }
            return  res;
        }

}
class TVerticalPair{
    int xcord;
    int ycord;
    Node node;
    TVerticalPair(int a ,int b,Node r){
        xcord = a;
        ycord = b;
        node = r;
    }
}
