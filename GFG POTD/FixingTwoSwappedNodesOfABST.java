//https://practice.geeksforgeeks.org/problems/6c4053871794c5e7a0817d7eaf88d71c4bb4c2bc/1
public class FixingTwoSwappedNodesOfABST {
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    Node prev = null , first = null , middle = null, last = null;
    public Node correctBST(Node root) {
        prev = new Node(Integer.MIN_VALUE);
        inorder(root);
        if(first!=null){
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }
        return root;
    }
    void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        if (root.data < prev.data){
            if(first == null){
                first = prev;
                last= root;
            }
            else last = root;
        }

        prev = root;
        inorder(root.right);
    }
}
