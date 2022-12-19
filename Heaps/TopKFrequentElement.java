// https://leetcode.com/problems/top-k-frequent-elements/description/
import java.util.*;

class TopKFrequentElement {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((first,second)->second.second - first.second);
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
      int res[] = new int[k];
        for(int i = 0 ; i<k ; i++){
            res[i] = pq.poll().first;
        }
       
        return res;
    }
    public static void main(String[] args) {
        int []nums = {1}; int k = 1;
        TopKFrequentElement sol = new TopKFrequentElement();
        System.out.println(Arrays.toString(sol.topKFrequent(nums, k)));
    }
}