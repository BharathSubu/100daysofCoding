//https://leetcode.com/problems/determine-if-string-halves-are-alike/

import java.util.*;

public class DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {

        HashSet<Character> vol = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int j = s.length()/2;
        int count1 = 0 , count2 = 0;
        for(int i = 0 ; i < j; i++){
            if(vol.contains(s.charAt(i))){
                count1++;
            }
            if(vol.contains(s.charAt(j+i))){
                count2++;
            }
        }
        if(count1==count2)
        return true;
        return false;
    }


}
