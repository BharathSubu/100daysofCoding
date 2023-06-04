//https://leetcode.com/problems/swap-nodes-in-pairs/
import java.util.*;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        while(temp!=null && temp.next!=null){
            int y = temp.val;
            temp.val = temp.next.val;
            temp.next.val = y;
            temp = temp.next.next;
        }
        return head;
    }
}
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
       ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }