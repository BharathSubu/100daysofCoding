//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
import java.util.*;
public class PopulatingNextRightPointer {

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        List<Node> sol = new ArrayList<>();
        if(root == null) return root;
        queue.add(root);
        sol.add(root);
        while(queue.size() !=0){
            for(int i = 0 ; i< sol.size()-1 ; i++){
                sol.get(i).next = sol.get(i+1);
            }
            List<Node> now= new ArrayList<>(sol);
            sol = new ArrayList<>();
            while(now.size() !=0){
                Node temp = queue.peek();
                if(temp.left != null) {
                    queue.add(temp.left);
                    sol.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                    sol.add(temp.right);
                }
                now.remove(0);
                queue.remove();
            }
        }
        return root;
    }
}
