// https://leetcode.com/problems/reduce-array-size-to-the-half/description/

import java.util.*;

class ReduceSizeToHalf {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i< arr.length ; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i = 0; i< arr.length ; i++){
            if(map.containsKey(arr[i])) {
                pq.add(map.get(arr[i]));
                map.remove(arr[i]);
            }
        }
        int size = arr.length;
        int count = 0;
        while(size > arr.length/2){
            int num = pq.poll();
            size-=num;
            count++;
        }
        return count;
    }
}