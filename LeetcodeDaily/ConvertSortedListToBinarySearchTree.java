import java.util.List;

//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        return createBST(head,null);
    }

    private TreeNode createBST(ListNode head, ListNode end) {
        if(head == null) return null;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=end && fast.next != end){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = createBST(head,slow);
        root.right = createBST(slow.next,end);
        return root;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class ListNode {
     int val;
     ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

