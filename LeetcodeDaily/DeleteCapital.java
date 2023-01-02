
//https://leetcode.com/problems/detect-capital/submissions/869413241/

import java.util.*;

public class DeleteCapital {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for(int i=0;i<word.length();i++)
        {
            if(Character.isUpperCase(word.charAt(i)))count++;
        }
        if(count==0 || count == word.length()) return true;
        if(count ==1 && (Character.isUpperCase(word.charAt(0)))) return true;
        return false;
    }
}