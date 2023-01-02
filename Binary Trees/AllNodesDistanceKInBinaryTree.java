//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
//https://practice.geeksforgeeks.org/problems/nodes-at-given-distance-in-binary-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=nodes-at-given-distance-in-binary-tree

import java.util.*;

public class AllNodesDistanceKInBinaryTree {



    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> res = new ArrayList<>();
        if(k==0) {
            res.add(target.val);
            return res;
        }

        HashMap<TreeNode,List<TreeNode>> map = new HashMap<>();
        constructGraph(root,map);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(target);
        int time = 0;

        while(!qu.isEmpty()){
            Queue<TreeNode> qu2 = new LinkedList<>();
            while (!qu.isEmpty()){
                visited.add(qu.peek());
                List<TreeNode> lst = map.get(qu.peek());
                for (TreeNode l:lst ) {
                    if(!visited.contains(l))
                        qu2.add(l);
                }
                qu.remove();
            }
            qu = new LinkedList<>(qu2);
            if(!qu.isEmpty())time++;
            if(time == k) {

                while (!qu2.isEmpty()){
                    res.add(qu2.remove().val);
                }

            }
        }
        return res;
    }


    private static void constructGraph(TreeNode root, HashMap<TreeNode, List<TreeNode>> map) {

        if(root == null) return;
        map.putIfAbsent(root,new ArrayList<>());
        if(root.left!=null){
            map.get(root).add(root.left);
            map.putIfAbsent(root.left,new ArrayList<>());
            map.get(root.left).add(root);
            constructGraph(root.left,map);
        }
        if(root.right!=null){
            map.get(root).add(root.right);
            map.putIfAbsent(root.right,new ArrayList<>());
            map.get(root.right).add(root);
            constructGraph(root.right,map);
        }
    }
    static Node target = null;
    public static ArrayList<Integer> KDistanceNodes(Node root, int tar , int k)
    {

        ArrayList<Integer> res = new ArrayList<>();
        if(k==0) {
            res.add(target.data);
            return res;
        }

        HashMap<Node,List<Node>> map = new HashMap<>();
        constructGraphGFG(root,map,tar);
        Set<Node> visited = new HashSet<>();
        Queue<Node> qu = new LinkedList<>();
        qu.add(target);
        int time = 0;

        while(!qu.isEmpty()){
            Queue<Node> qu2 = new LinkedList<>();
            while (!qu.isEmpty()){
                visited.add(qu.peek());
                List<Node> lst = map.get(qu.peek());
                for (Node l:lst ) {
                    if(!visited.contains(l))
                        qu2.add(l);
                }
                qu.remove();
            }
            qu = new LinkedList<>(qu2);
            if(!qu.isEmpty())time++;
            if(time == k) {

                while (!qu2.isEmpty()){
                    res.add(qu2.remove().data);
                }
            }
        }
        return res;
    }

    private static void constructGraphGFG(Node root, HashMap<Node, List<Node>> map , int tar) {

        if(root == null) return;
        if(root.data == tar) target = root;
        map.putIfAbsent(root,new ArrayList<>());
        if(root.left!=null){
            map.get(root).add(root.left);
            map.putIfAbsent(root.left,new ArrayList<>());
            map.get(root.left).add(root);
            constructGraphGFG(root.left,map,tar);
        }
        if(root.right!=null){
            map.get(root).add(root.right);
            map.putIfAbsent(root.right,new ArrayList<>());
            map.get(root.right).add(root);
            constructGraphGFG(root.right,map,tar);
        }
    }
}
