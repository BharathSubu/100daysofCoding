//https://practice.geeksforgeeks.org/problems/linked-list-insertion-1587115620/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=linked-list-insertion

class Solution {
    // Function to insert a node at the beginning of the linked list.
    Node insertAtBeginning(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) {
            head = temp;
        } else {
            temp.next = head;
            head = temp;
        }
        return head;
    }

    // Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x) {
        Node insert = new Node(x);
        if (head == null) {
            head = insert;
            return head;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = insert;
        return head;
    }

}