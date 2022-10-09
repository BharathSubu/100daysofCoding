//https://leetcode.com/problems/intersection-of-two-linked-lists/submissions/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode inter = new ListNode();
        while (headA != null) {
            map.put(headA, 1);
            headA = headA.next;
        }
        while (headB != null) {
            if (map.get(headB) != null)
                return headB;
            headB = headB.next;
        }
        return inter;
    }
}