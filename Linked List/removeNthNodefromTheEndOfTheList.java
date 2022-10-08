//https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (getlength(head) == 1)
            return null;
        int k = getlength(head) - n;
        if (k == 0) {
            return head.next;
        }

        ListNode temp = head;
        while (temp.next != null) {
            k--;
            if (k == 0) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;

    }

    public int getlength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}