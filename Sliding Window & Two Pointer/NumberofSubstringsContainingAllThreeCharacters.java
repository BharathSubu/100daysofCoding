// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

import java.util.*;


class NumberofSubstringsContainingAllThreeCharacters {
    public  static int numberOfSubstrings(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        int start = 0;
        for (int i = 0; i < s.length() ; i++) {
            if(map.size() < 3){
                if(!map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i), 1);
                }
                else{
                    map.put(s.charAt(i), map.get(s.charAt(i))+1);
                }
            }
            if(map.size() == 3) {
                while(map.size()==3){
                   count+=s.length()-i;
                   map.put(s.charAt(start), map.get(s.charAt(start))-1);
                   if(map.get(s.charAt(start)) == 0) map.remove(s.charAt(start));
                   start++;
                }
            }
            // System.out.println(map+" "+count);
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcaaaabbbbccccaaaaaaabbbbaaaccababcbaaabcbc"));
    }

}