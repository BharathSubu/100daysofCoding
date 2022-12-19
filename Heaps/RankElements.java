import java.util.HashMap;
import java.util.PriorityQueue;

import javax.print.attribute.HashAttributeSet;

// https://practice.geeksforgeeks.org/problems/replace-elements-by-its-rank-in-the-array/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=replace-elements-by-its-rank-in-the-array


class RankElements {
    static int[] replaceWithRank(int arr[], int N) {
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer integer : arr) {
            pq.add(integer);
        }
        int prev = -1;
        int rank = 1;
        while(!pq.isEmpty()){
            if(prev == pq.peek()){
                pq.poll();
            }
            else{
                prev = pq.poll();
                map.put(prev, rank);
                rank++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    } 
}