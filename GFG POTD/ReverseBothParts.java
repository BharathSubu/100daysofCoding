

//https://practice.geeksforgeeks.org/problems/bae68b4d6a2a77fb6bd459cf7447240919ebfbf5/1

import java.util.*;

public class ReverseBothParts {
    class Node
    {
        int data;
        Node next;

        Node(int x){
            data = x;
            next = null;
        }
    }

    public static Node reverse(Node head1, int k) {
        Node head2 = head1;
        while (k!=0) {
            head2 = head2.next;
            k--;
        }
        head1 = reverse(head1 , head2);
        head2 = reverse(head2 , null);
        Node temp = head1;
        while (temp.next != null) temp = temp.next;
        temp.next = head2;
        return head1;
    }

    static Node reverse(Node head, Node head2){
        Node prev = null;
        Node curr = head;
        Node next = curr;
        while(curr!=head2){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

