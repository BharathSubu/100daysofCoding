//https://practice.geeksforgeeks.org/problems/find-length-of-loop/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-length-of-loop

/*
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

//Function should return the length of the loop in LL.

class Solution {
    // Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head) {
        Node slow = head;
        Node fast = head;
        int flag = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                flag = 1;
                break;
            }
        }
        int count = 0;
        if (flag == 1) {
            do {
                slow = slow.next;
                count++;

            } while (slow != fast);

        }

        return count;
    }
}