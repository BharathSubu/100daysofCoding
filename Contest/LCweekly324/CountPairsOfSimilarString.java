// https://leetcode.com/contest/weekly-contest-324/problems/count-pairs-of-similar-strings/

import java.util.*;
import java.util.stream.Collectors;

class CountPairsOfSimilarString {
    
    public static int similarPairs(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length - 1; i++) {
            String word = words[i];
            List<Character> first = word.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
            HashSet<Character> set1 = new HashSet<>(first);
        
            for (int j = i + 1; j < words.length; j++) {
                List<Character> second = words[j].chars().mapToObj(e -> (char)e).collect(Collectors.toList());
                HashSet<Character> set2 = new HashSet<>(second);
                if(set1.equals(set2))res++;
                 
            }
            
        }
        return res;
    }
    public static void main(String[] args) {
        String arr[] = {"aba","aabb","abcd","bac","aabc"};
        System.out.println(similarPairs(arr));
    }
   
}