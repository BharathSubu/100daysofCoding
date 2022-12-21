import java.util.ArrayList;
import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=merge-k-sorted-arrays

class MergekSortedArrays
{
   //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int []ar : arr) {
            for (int a : ar) {
                pq.add(a);
            }
        }
        ArrayList<Integer> merge = new ArrayList<>();
        while(!pq.isEmpty()){
            merge.add(pq.poll());
        }
        return merge;
        
    }
}