//https://practice.geeksforgeeks.org/problems/95423710beef46bd66f8dbb48c510b2c320dab05/1
import java.util.*;
public class ConnectNodesAtSameLevel {
    class Node{
        int data;
        Node left;
        Node right;
        Node nextRight;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
            nextRight = null;
        }
    }
    public void connect(Node root) {
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()){
            Queue<Node> qu2 = new LinkedList<>();
            while (!qu.isEmpty()){
                Node temp = qu.remove();
                if(temp.left!=null) qu2.add(temp.left);
                if(temp.right!=null) qu2.add(temp.right);
            }
            Node prev = null;
            while (!qu2.isEmpty()){
                Node temp = qu2.remove();
                if(prev!=null) prev.nextRight  = temp;
                qu.add(temp);
                prev = temp;
            }
        }
    }
}
