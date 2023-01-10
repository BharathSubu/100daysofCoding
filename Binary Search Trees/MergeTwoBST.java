
// https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
import java.util.*;

class MergeTwoBST {
    public List<Integer> merge(Node root1, Node root2) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        Node curr1 = root1;
        Node curr2 = root2;
        List<Integer> ans = new ArrayList<>();
        while (curr1 != null || curr2 != null || !s1.empty() || !s2.empty()) {
            while (curr1 != null) {
                s1.push(curr1);
                curr1 = curr1.left;
            }
            while (curr2 != null) {
                s2.push(curr2);
                curr2 = curr2.left;
            }
            if(!s1.isEmpty() && !s2.isEmpty() ){
                if(s1.peek().data >= s2.peek().data){
                    ans.add(s2.peek().data);
                    curr2 = s2.pop();
                    System.out.print(curr2.data + " ");
                    curr2 = curr2.right; 
                }
                else if(s2.peek().data > s1.peek().data){
                    ans.add(s1.peek().data);
                    curr1 = s1.pop();
                    System.out.print(curr1.data + " ");
                    curr1 = curr1.right; 
                }
            }
            else if (!s1.isEmpty()){
                ans.add(s1.peek().data);
                curr1 = s1.pop();
                System.out.print(curr1.data + " ");
                curr1 = curr1.right; 
            }
            else if (!s2.isEmpty()){
                ans.add(s2.peek().data);
                curr2 = s2.pop();
                System.out.print(curr2.data + " ");
                curr2 = curr2.right; 
            }
        }
        return ans;
    }

}