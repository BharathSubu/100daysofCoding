
//https://leetcode.com/problems/letter-case-permutation/description/
import java.util.*;

public class LetterCasePermutation {
    List<String> res = new ArrayList<>();
    StringBuilder sol = new StringBuilder();
    public List<String> letterCasePermutation(String s) {
        s = s.toLowerCase();
        letterCasePermutation(s,0);
        return res;
    }
    void letterCasePermutation(String s , int posi){

        while(posi < s.length() && !(s.charAt(posi) >= 'a' && s.charAt(posi) <= 'z')){
            sol.append(s.charAt(posi));
            posi++;
        }
        if(posi >= s.length()){
            res.add(sol.toString());
//            sol.deleteCharAt(sol.length()-1);
            return;
        }
        sol.append(s.charAt(posi));
        letterCasePermutation(s,posi+1);
        sol.delete(posi , sol.length());
        char ch = Character.toUpperCase(s.charAt(posi));
        sol.append(ch);
        letterCasePermutation(s,posi+1);
        sol.delete(posi , sol.length());
    }

    public static void main(String[] args) {
        LetterCasePermutation sol = new LetterCasePermutation();
        List<String> res = sol.letterCasePermutation("a1b2");
        System.out.println(res);
    }
}
