//https://practice.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-pairs-with-given-sum-in-doubly-linked-list
/*
Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;
    
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        HashMap<Integer, Integer> map = new HashMap<>();

        Node temp = head;
        while (temp != null) {
            int snum = target - temp.data;
            if (map.get(snum) != null) {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                arr.add(snum);
                arr.add(temp.data);
                res.add(0, arr);
            }
            map.put(temp.data, temp.data);
            temp = temp.next;
        }
        return res;
    }
}