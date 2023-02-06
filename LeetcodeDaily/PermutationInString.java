
//https://leetcode.com/problems/permutation-in-string/description/
import java.util.*;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> original = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            original.put(s1.charAt(i),original.getOrDefault(s1.charAt(i),0)+1);
        }
        int have = 0 , need = original.size();
        HashMap<Character,Integer> duplicate = new HashMap<>();
        int start = 0;
        for(int i =0;i<s2.length();i++){
            char c = s2.charAt(i);
            if(original.containsKey(c)){
                duplicate.put(c, duplicate.getOrDefault(c,0)+1);
                if(duplicate.get(c).equals(original.get(c))) have++;
            }
            if(have==need) {
                while (have == need && start < i) {
                    char atS = s2.charAt(start);
                    if (original.containsKey(atS)) {
                        duplicate.put(atS, duplicate.getOrDefault(atS, 0) - 1);
                        if (duplicate.get(atS) < original.get(atS))
                        {
                            have--;
                            break;
                        }
                    }
                    start++;
                }
                int len = i - start + 1;
                if (len == s1.length()) return true;
                start++;
            }
        }
        System.out.println(duplicate);
        return false;

    }
}
