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