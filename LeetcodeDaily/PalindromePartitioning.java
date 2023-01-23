//https://leetcode.com/problems/palindrome-partitioning/description/

import java.util.*;

public class PalindromePartitioning {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> r = new ArrayList<>();
        partition(0,r,s);
        return res;
    }
    void partition(int i,List<String> r,String s){
        System.out.println(r);
        if(i >= s.length()) {
            System.out.println(r);
            res.add(new ArrayList<>(r));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            String sub = s.substring(i,j+1);
            if(isPlaindrome(sub)){
                r.add(sub);
                partition(j+1,r,s);
                r.remove(r.size()-1);
            }
        }

    }
    boolean isPlaindrome(String s){
        int i = 0, j = s.length()-1;
        while (i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning sol = new PalindromePartitioning();
        System.out.println(sol.partition("cbbbcc"));
    }
}
