//https://leetcode.com/problems/rotate-list/submissions/
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
    public ListNode rotateRight(ListNode head, int k) {

        int len = getLength(head);
        if (len == 0)
            return head;
        k = k % len;
        if (k == 0)
            return head;
        ListNode temp = head;
        int end = len - k;
        ListNode endN = null;
        while (temp.next != null) {
            end--;
            if (end == 0) {
                endN = temp;
            }
            temp = temp.next;
        }

        temp.next = head;
        head = endN.next;
        endN.next = null;
        return head;
    }

    public int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}