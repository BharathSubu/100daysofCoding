// https://practice.geeksforgeeks.org/problems/maximum-sum-combination/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=maximum-sum-combination

import java.util.*;
class MaximumSumCombination {
        static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
            PriorityQueue<Integer>pq=new PriorityQueue<Integer>(Collections.reverseOrder());
               for(int i=0;i<N;i++){
                   for(int j=0;j<N;j++){
                       int sum=A[i]+B[j];
                       pq.add(sum);
                   }
               }
               List<Integer>ans=new ArrayList<Integer>();
               int k=0;
               while(k++<K){
                   ans.add(pq.poll());
               }
               return ans;
    }
}