//https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
import java.util.*;
public class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        Stack<Integer> st  = new Stack<>();
        ListNode slow = head;
        ListNode fast = slow;
        while(fast!= null && fast.next != null){
            st.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        int sum = Integer.MIN_VALUE;
        while (slow!=null){
            sum = Math.max(sum,slow.val+st.pop());
            slow = slow.next;
        }
        return sum;
    }
}
