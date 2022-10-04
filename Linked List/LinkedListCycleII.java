//https://leetcode.com/problems/linked-list-cycle-ii/
/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pos = new ListNode();
        int isfound = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                pos = slow;
                isfound = 1;
                break;
            }

        }
        ListNode temp = head;
        int idx = 0;
        if (isfound == 1) {

            while (temp != fast) {
                temp = temp.next;
                fast = fast.next;
            }
            return temp;
        }
        return null;
    }
}