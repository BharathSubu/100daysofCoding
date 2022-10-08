//https://leetcode.com/problems/reorder-list/submissions/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode mid = getmid(head);
        ListNode hs  = reverseNode(mid);
        ListNode hf = head;
       
        while(hf!=null && hs !=null){
            ListNode temp2 = hf.next;
            hf.next = hs ;
            hf = temp2;
            temp2 = hs.next;
            hs.next = hf; 
            hs = temp2;
        }
        if(hf!=null){
            hf.next = null;
        }
    }
    
    public ListNode reverseNode(ListNode head){
        if(head == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode after = curr.next;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = after;
            if(after !=null )after = after.next;
        }
        return prev;
    }
    
    public ListNode getmid(ListNode head){
     
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}