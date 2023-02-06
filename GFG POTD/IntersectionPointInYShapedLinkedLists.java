
//https://practice.geeksforgeeks.org/problems/eae1fbd0ac8f213a833d231e26ba4d829e79dd9c/1

import java.util.*;

public class IntersectionPointInYShapedLinkedLists {
    class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }
    class LinkedList
    {
        Node head;  // head of list
    }
    int intersectPoint(Node head1, Node head2)
    {
        HashSet<Node> set = new HashSet<>();
        while(head1!=null) {
            set.add(head1);
            head1 = head1.next;
        }
        while(head2!=null){
            if(set.contains(head2)) return head2.data;
            head2 = head2.next;
        }
        return -1;
    }
}
