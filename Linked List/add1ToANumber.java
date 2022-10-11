//https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=add-1-to-a-number-represented-as-linked-list

/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution {
    public static Node addOne(Node head) {
        head = reverse(head);
        int carry = 1;
        Node temp = head;

        do {

            int num = temp.data + carry;
            carry = num / 10;
            temp.data = num % 10;
            // System.out.println(num +" "+carry + " " + temp.data);
            if (temp.next == null && carry != 0) {
                Node insert = new Node(1);
                temp.next = insert;
                break;
            }
            temp = temp.next;
        } while (carry != 0);

        return reverse(head);
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}