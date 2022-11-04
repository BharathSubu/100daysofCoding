//https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/submissions/836753372/

import java.util.*;

public class Leetcode1461 {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
           set.add(s.substring(i,i+k));
        }
        if(set.size() == Math.pow(2,k))
        return true;
        return false;
    }

    public static void main(String[] args) {
        Leetcode1461 sol = new Leetcode1461();
        System.out.println(sol.hasAllCodes("0110" , 2));
    }
}
