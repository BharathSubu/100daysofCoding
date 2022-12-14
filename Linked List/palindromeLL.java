//https://leetcode.com/problems/palindrome-linked-list/

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

// improved

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode temp = head;
        ListNode mid = getMid(head);
        ListNode hs = reverse(mid);

        while (hs != null) {
            if (temp.val != hs.val)
                return false;
            temp = temp.next;
            hs = hs.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode newnode = curr.next;
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = newnode;
            if (newnode != null)
                newnode = newnode.next;
        }
        return prev;
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

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        head = reverseList(head, head, null, slow);
        if (fast != null)
            slow = slow.next;
        ListNode temp = head;
        System.out.println(slow.val);

        while (slow != null) {
            if (slow.val != temp.val)
                return false;
            System.out.println(slow.val + " " + temp.val);
            slow = slow.next;
            temp = temp.next;

        }
        return true;

    }

    public ListNode reverseList(ListNode newnode, ListNode curr, ListNode prev, ListNode end) {
        if (curr == end)
            return prev;
        newnode = curr.next;
        curr.next = prev;
        prev = curr;
        curr = newnode;
        return reverseList(newnode, curr, prev, end);

    }
}