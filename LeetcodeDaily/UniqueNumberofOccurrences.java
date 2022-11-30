//https://leetcode.com/problems/unique-number-of-occurrences/description/

import  java.util.*;

public class UniqueNumberofOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : arr){
            if (map.containsKey(i)) {
                map.put(i,map.get(i)+1);
            } else {
                map.put(i,1);
            }
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (Integer v : map.values()) {
            if(set.contains(v)) return false;
            set.add(v);
        }
        return true;
    }
}
