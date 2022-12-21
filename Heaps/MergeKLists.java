
// https://leetcode.com/problems/merge-k-sorted-lists/

import java.util.*;

class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListPair> pq = new PriorityQueue<>((first,second)->first.data-second.data);
        for (ListNode head : lists) {
            while(head != null){
                pq.add(new ListPair(head.val , head));
                head = head.next;
            }
        }
        if(pq.size() == 0) return null;
        ListNode head = pq.poll().node;
        ListNode temp = head;
        temp.next = null;
        while(!pq.isEmpty()){
            // System.out.println(pq.poll().data);
            temp.next = pq.poll().node;
            temp = temp.next;
            temp.next = null;
        }
        return head;

    }
}

class  ListPair{
    int data;
    ListNode node;
    ListPair(int d , ListNode n){
        data = d;
        node = n;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}