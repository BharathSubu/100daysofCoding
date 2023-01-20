//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/description/

import java.util.*;

public class PairsOfSongs {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for (int t:time ) {
           int searchKey = 60 - t%60;
           if(map.containsKey(searchKey)) {
               count += map.get(searchKey);
           }
           if(t%60 != 0)
           map.put(t%60,map.getOrDefault(t%60,0)+1);
           else map.put(60, map.getOrDefault(60,0)+1);
        }
        return count;

    }

    public static void main(String[] args) {
        PairsOfSongs sol = new PairsOfSongs();
        int arr[]={60,60,60};
        System.out.println(sol.numPairsDivisibleBy60(arr));
    }
}
