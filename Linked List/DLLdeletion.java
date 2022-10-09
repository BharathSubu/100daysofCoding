//https://practice.geeksforgeeks.org/problems/delete-node-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=delete-node-in-doubly-linked-list

/* Structure of linkedlist node
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}
*/
class Solution {
    // function returns the head of the linkedlist
    Node deleteNode(Node head, int x) {
        Node prev = null;
        Node temp = head;
        int n = x;
        while (--x > 0) {
            prev = temp;
            temp = temp.next;
        }
        if (prev != null)
            prev.next = temp.next;
        if (temp.next != null)
            temp.next.prev = prev;
        if (n == 1)
            return temp.next;
        else {
            return head;
        }
    }
}