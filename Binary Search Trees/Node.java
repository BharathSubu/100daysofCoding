public class Node {
    public int data;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        data = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        data = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
