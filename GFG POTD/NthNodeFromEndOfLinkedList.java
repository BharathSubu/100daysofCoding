//https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1
import java.util.*;
public class NthNodeFromEndOfLinkedList {
    int getNthFromLast(Node head, int n)
    {
        int reqNode = getLength(head) - n;
        if(reqNode < 0) return -1;
        Node curr = head;
        for(int idx=0; idx < reqNode; idx++, curr = curr.next);
        return curr.data;
    }

    int getLength(Node head)
    {
        int length = 0;
        for(Node curr = head; curr != null; curr = curr.next)
        {
            length++;
        }
        return length;
    }
    class Node{
        int data;
        Node next;
    }
}
