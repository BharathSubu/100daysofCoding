//https://leetcode.com/problems/verifying-an-alien-dictionary/

import java.util.*;

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0; i<order.length() ; i++) map.put(order.charAt(i),i);
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i+1];
            int j = 0;
            while(j < first.length() && j < second.length() && first.charAt(j) == second.charAt(j)){
                j++;
            }
            if(j == first.length()){
                continue;
            }
            else{
                if(j == second.length() || map.get(first.charAt(j)) > map.get(second.charAt(j))) return false;
            }
        }
        return true;
    }
}
