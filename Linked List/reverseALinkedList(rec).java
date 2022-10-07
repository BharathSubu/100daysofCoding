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
        return reverseList(head, head, null);
    }

    public ListNode reverseList(ListNode newnode, ListNode curr, ListNode prev) {
        if (curr == null)
            return prev;
        newnode = curr.next;
        curr.next = prev;
        prev = curr;
        curr = newnode;
        return reverseList(newnode, curr, prev);

    }
}