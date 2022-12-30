//https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=left-view-of-binary-tree
import java.util.*;

public class BinaryTreeLeftSideView {
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<Node>();
        ArrayList<Integer> sol = new ArrayList<>();
        if(root == null) return res;
        queue.add(root);
        sol.add(root.data);
        while(queue.size() !=0){
            res.add(sol.get(0));
            List<Integer> now= new ArrayList<>(sol);
            sol = new ArrayList<>();
            while(now.size() !=0){
                Node temp = queue.peek();
                if(temp.left != null) {
                    queue.add(temp.left);
                    sol.add(temp.left.data);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                    sol.add(temp.right.data);
                }
                now.remove(0);
                queue.remove();
            }
        }
        return res;
    }
}
