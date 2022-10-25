// https://leetcode.com/problems/palindrome-partitioning/
import java.util.*;

public class PalindromePartitioning {

    boolean ispalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }

    List<List<String>> res = new ArrayList<>();
    List<StringBuilder> strarr = new ArrayList<>();
    StringBuilder str = new StringBuilder();

    public List<List<String>> partition(String s) {
        str.append(s.charAt(0));
        partition(s, 1);
        return res;
    }

    void partition(String s, int posi) {
        System.out.println(str);
        if (posi == s.length()) {
            if (ispalindrome(str.toString())) {
                strarr.add(str);
                List<String> newarr = new ArrayList<>();
                for (int i = 0; i < strarr.size(); i++) {
                    newarr.add(strarr.get(i).toString());
                }
                res.add(new ArrayList<>(newarr));
             strarr.remove(strarr.size() - 1 );

            }
            return;
        }

        if (ispalindrome(str.toString())) {
             strarr.add(str);
             StringBuilder now = new StringBuilder(str);
             str = new StringBuilder();
             str.append(s.charAt(posi));
             partition(s, posi + 1);

             strarr.remove(strarr.size() - 1 );
             str = new StringBuilder(now);
             str.append(s.charAt(posi));
             partition(s, posi + 1);

        } else {
            str.append(s.charAt(posi));
            partition(s, posi + 1);
        }
    }

    public static void main(String[] args) {

        PalindromePartitioning sol = new PalindromePartitioning();
        List<List<String>> res = sol.partition("aab");
        System.out.println(res);
    }
}