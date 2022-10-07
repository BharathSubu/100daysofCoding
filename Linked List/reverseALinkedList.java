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
    public ListNode reverseList(ListNode head) {
        ListNode newnode = head;
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            newnode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newnode;
        }
        head = prev;
        return head;
    }
}