// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.*;

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            while(set.contains(s.charAt(i))){
                max = Math.max(max, i - start);
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(i));
        }
        max = Math.max(max, s.length() - start);
        return max; 
    }
}