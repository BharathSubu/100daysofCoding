//https://leetcode.com/problems/determine-if-two-strings-are-close/description/

import java.util.*;

public class DetermineifTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if(word2.length() != word1.length()) return false;
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            if(map1.containsKey(word1.charAt(i))){
                map1.put(word1.charAt(i),map1.get(word1.charAt(i))+1);
            }
            else{
                map1.put(word1.charAt(i),1);
            }
            if(map2.containsKey(word2.charAt(i))){
                map2.put(word2.charAt(i),map2.get(word2.charAt(i))+1);
            }
            else{
                map2.put(word2.charAt(i),1);
            }
        }
        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new ArrayList<>();

        map1.forEach((k, v)-> lst1.add(v) );
        map2.forEach((k, v)-> lst2.add(v) );

        Collections.sort(lst1);
        Collections.sort(lst2);

        for(int i = 0 ; i<lst1.size() ; i++){
            if(lst1.get(i)!=lst2.get(i)) return false;
        }
        return true;
    }
}
