
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
        while(!pq.isEmpty()){
            System.out.println(pq.poll().data);
        }
        return null;

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