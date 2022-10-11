//https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=given-a-linked-list-of-0s-1s-and-2s-sort-it

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {

    static Node segregate(Node head) {
        Node zeroHead = null;
        Node zero = null;
        Node oneHead = null;
        Node one = null;
        Node twoHead = null;
        Node two = null;
        Node temp = head;
        while (temp != null) {
            Node next = temp.next;
            if (temp.data == 0) {
                if (zeroHead == null) {
                    zeroHead = temp;
                    zero = temp;
                    zero.next = null;
                } else {
                    zero.next = temp;
                    zero = temp;
                    zero.next = null;
                }

            } else if (temp.data == 1) {
                if (oneHead == null) {
                    oneHead = temp;
                    one = temp;
                    one.next = null;
                } else {
                    one.next = temp;
                    one = temp;
                    one.next = null;
                }
            } else if (temp.data == 2) {
                if (twoHead == null) {
                    twoHead = temp;
                    two = temp;
                    two.next = null;
                } else {
                    two.next = temp;
                    two = temp;
                    two.next = null;
                }
            }
            temp = next;
        }
        Node newHead = null;
        if (zeroHead != null) {
            newHead = zeroHead;
            Node temp1 = zero;
            if (oneHead != null) {
                temp1.next = oneHead;
                temp1 = one;
            }
            if (twoHead != null) {
                temp1.next = twoHead;
            }
        } else {
            if (oneHead != null) {
                newHead = oneHead;
                Node temp1 = one;
                if (twoHead != null) {
                    temp1.next = twoHead;
                }
            } else {
                return twoHead;
            }
        }

        return newHead;
    }
}