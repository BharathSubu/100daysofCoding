import java.util.*;

public class BurningTree {
    static Node targetN = null;
    public static int minTime(Node root, int target)
    {
        //reconstructing the tree into graph;
        //then BST traversal

        HashMap<Node,List<Node>> map = new HashMap<>();
        constructGraph(root,map,target);
        Set<Node> visited = new HashSet<>();
        Queue<Node> qu = new LinkedList<>();
        qu.add(targetN);
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
        }

        return time;
    }


    private static void constructGraph(Node root, HashMap<Node, List<Node>> map,  int target) {

        if(root == null) return;
        if(root.data == target) targetN = root;
        map.putIfAbsent(root,new ArrayList<>());
        if(root.left!=null){
            map.get(root).add(root.left);
            map.putIfAbsent(root.left,new ArrayList<>());
            map.get(root.left).add(root);
            constructGraph(root.left,map,  target);
        }
        if(root.right!=null){
            map.get(root).add(root.right);
            map.putIfAbsent(root.right,new ArrayList<>());
            map.get(root.right).add(root);
            constructGraph(root.right,map,  target);
        }
    }

}
