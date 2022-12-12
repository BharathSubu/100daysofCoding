//https://leetcode.com/problems/minimum-window-substring/

import java.util.*;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        String res = "";
        if(s.length()<t.length()){
            return res;
        }
        HashMap<Character , Integer > original = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            original.put(t.charAt(i),original.getOrDefault(t.charAt(i),0)+1);
        }
        HashMap<Character , Integer > window = new HashMap<>();
        int have = 0;
        int need = original.size();
        int start = 0;
        int length = s.length() + 1;
        int minLeftIndex =0;

        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(original.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(original.get(c))  ){
                    have++;
                }
            }
            while (have == need){
                if(length > (i-start + 1)){
                    length = i-start+1;
                    minLeftIndex = start;
                }

                if(original.containsKey(s.charAt(start))){
                    window.put(s.charAt(start),window.get(s.charAt(start))-1);
                    if(window.get(s.charAt(start)) < original.get(s.charAt(start))){
                        have--;
                    }
                }
                start++;
            }
        }
        if (length > s.length()) {
            return "";
        }
        return s.substring(minLeftIndex, minLeftIndex + length);
    }
}
