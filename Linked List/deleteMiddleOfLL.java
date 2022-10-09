//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/submissions/

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
    public ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null)
            return null;

        ListNode mid = getMid(head);
        ListNode temp = head;
        while (temp.next != mid) {
            temp = temp.next;
        }
        temp.next = mid.next;
        return head;
    }

    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}