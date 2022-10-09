// https://leetcode.com/problems/reverse-linked-list-ii/submissions/

//improved

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < left - 1; i++)
            prev = prev.next;

        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {
            ListNode frow = curr.next;
            curr.next = frow.next;
            frow.next = prev.next;
            prev.next = frow;
        }
        return dummy.next;
    }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || left > right)
            return head;
        if (head == null || head.next == null)
            return head;
        ListNode start = head;
        if (left == 1) {
            start = null;
        } else {
            while (--left > 1) {
                start = start.next;
            }
        }
        if (start != null)
            System.out.println(start.val);
        else
            System.out.println("null");
        ListNode end = head;
        while (--right > 0 && end.next != null) {
            end = end.next;
        }
        end = end.next;
        if (end != null)
            System.out.println(end.val);
        else
            System.out.println("null");
        // return head;
        return reverse(head, start, end);
    }

    public ListNode reverse(ListNode head, ListNode start, ListNode end) {
        ListNode temp = head;
        ListNode prev = end;
        ListNode curr = null;
        if (start == null) {
            temp = head;
        } else {
            while (temp != start) {
                temp = temp.next;
            }
            temp = temp.next;
        }
        curr = temp;
        while (curr != end) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        if (end == null && start != null) {
            start.next = prev;
            return head;
        } else if (start == null) {
            return prev;
        } else {
            start.next = prev;
            return head;
        }
    }
}
