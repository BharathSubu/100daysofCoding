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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1, temp2;
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val < list2.val) {
            temp1 = list1;
            temp2 = list2;
        } else {
            temp2 = list1;
            temp1 = list2;
        }

        ListNode head = temp1;
        ListNode curr = temp1;
        while (temp1 != null && temp2 != null) {

            if (temp1.val <= temp2.val) {
                curr = temp1;
                temp1 = temp1.next;
            } else if (temp1.val > temp2.val) {

                ListNode ins = new ListNode(temp2.val);
                ins.next = temp1;
                curr.next = ins;
                curr = ins;
                temp2 = temp2.next;
            }
        }
        while (temp1 != null) {
            curr.next = temp1;
            curr = curr.next;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            curr.next = temp2;
            curr = curr.next;
            temp2 = temp2.next;
        }
        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0)
            return null;
        if (n == 1)
            return lists[0];
        ListNode head = lists[0];
        for (int i = 1; i < n; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }
}