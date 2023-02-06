//https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

import java.util.*;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> original = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            original.put(c, original.getOrDefault(c,0)+1);
        }
        HashMap<Character,Integer> duplicate = new HashMap<>();
        int have = 0;
        int need = original.size();
        int start = 0;

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(original.containsKey(c)){
                duplicate.put(c,duplicate.getOrDefault(c,0)+1);
                if(duplicate.get(c).equals(original.get(c))) have++;
            }
            if(have == need){
                while(have == need && start < i){
                    char atS = s.charAt(start);
                    if(original.containsKey(atS)){
                        duplicate.put(atS,duplicate.getOrDefault(atS,0)-1);
                        if(duplicate.get(atS) < original.get(atS)) {
                            have--;
                            break;
                        }
                    }
                    start++;
                }
                int len = i - start + i;
                if(len == p.length()) ans.add(start);
                start++;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        FindAllAnagramsInAString sol = new FindAllAnagramsInAString();
        String s = "cbaebabacd", p = "abc";
        System.out.println(sol.findAnagrams(s,p));
    }
}
