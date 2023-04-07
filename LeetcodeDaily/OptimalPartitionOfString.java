//https://leetcode.com/problems/optimal-partition-of-string/

import java.util.*;

public class OptimalPartitionOfString {
    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))){
                count++;
                set = new HashSet<>();
            }
            set.add(s.charAt(i));
        }
        return count;
    }
}
