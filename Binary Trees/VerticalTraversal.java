//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/

import java.util.*;

public class VerticalTraversal {

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> res = getVerticalOrderBFS(root);
            return res;
        }
        public static List<List<Integer>> getVerticalOrderBFS(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            Queue<VerticalPair> qu = new LinkedList<>();
            int max = 0;
            int min = 0;
            HashMap<Integer,List<CordPair>> map = new HashMap<>();
            if(root == null) return res;
            int level =0;
            qu.add(new VerticalPair(0,level,root));
            while (!qu.isEmpty()){
                Queue<VerticalPair> qu2 = new LinkedList<>();
                level++;
                List<Integer> levelEle = new ArrayList<>();
                while(qu.size()!=0){
                    VerticalPair p = qu.remove();
                    TreeNode node = p.node;
                    int val = p.xcord;
                    max = Math.max(max,val);
                    min = Math.min(min,val);
                    map.putIfAbsent(val,new ArrayList<>());
                    map.get(val).add(new CordPair(p.ycord,node.val));
//                System.out.println(node.val);
                    if(node.left!= null) {
                        qu2.add(new VerticalPair(val-1,level,node.left));
                    }
                    if(node.right!= null) {
                        qu2.add(new VerticalPair(val+1,level,node.right));
                    }
                }
                if(!qu2.isEmpty())
                    qu = new LinkedList<>(qu2);
            }

            for (int i = min; i < max+1; i++) {
                List<CordPair> r = new ArrayList<>(map.get(i));
                Collections.sort(r, (entry1, entry2) -> {
                    if((entry1.cord == entry2.cord))
                        return entry1.val - entry2.val;
                    return entry1.cord - entry2.cord;
                });
                List<Integer> lst = new ArrayList<>();
                for(CordPair c : r){
                    lst.add(c.val);
                }
                res.add(lst);
            }
            return  res;
        }
    }

    class VerticalPair{
        int xcord;
        int ycord;
        TreeNode node;
        VerticalPair(int a ,int b,TreeNode r){
            xcord = a;
            ycord = b;
            node = r;
        }
    }

    class CordPair{
        int cord;
        int val;
        CordPair(int a ,int r){
            cord = a;
            val = r;
        }
    }
