//https://leetcode.com/problems/sort-list/

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

    public ListNode sortList(ListNode head) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            n++;
        }
        temp = head;
        ListNode prev = null;
        for (int i = 0; i < n; i++) {
            ListNode start = head;
            ListNode end = start.next;
            for (int j = 0; j < n - i - 1; j++) {

                if (start == head) {
                    if (start.val >= end.val) {
                        head = end;
                        start.next = end.next;
                        end.next = start;
                        start = head.next;
                        end = start.next;
                        prev = head;
                    } else {
                        prev = start;
                        start = start.next;
                        end = start.next;
                    }

                } else {
                    if (start.val >= end.val) {
                        prev.next = end;
                        start.next = end.next;
                        end.next = start;
                        prev = end;
                        start = end.next;
                        end = start.next;
                    } else {
                        prev = start;
                        start = start.next;
                        end = start.next;
                    }
                }
            }
        }
        return head;
    }

}