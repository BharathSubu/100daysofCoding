
// https://leetcode.com/contest/weekly-contest-325/problems/take-k-of-each-character-from-left-and-right/
import java.util.*;

class TakeKofEachCharacter {
    public static int takeCharacters(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (map.size() != 3)
            return -2;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() < k)
                return -1;
        }
        int n = s.length() - 1;
        int Rstart = -1;
        int Lend = n;
        for (int i = n; i >= 0; i--) {
            if (i >= n - i) {
                int count = map.get(s.charAt(i));
                if (count - 1 < k) {
                    Rstart = i;
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                }
            } else {
                int count = map.get(s.charAt(i));
                if (count - 1 < k) {
                    Lend = i;
                    break;
                }
                else{
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                }
            }
        }
        int llen = Lend - 0 + 1;
        int rlen = 0;
        if (Rstart != 0)
            rlen = s.length() - Rstart;
        System.out.println(llen+" "+rlen);
        return llen + rlen;
    }

    public static void main(String[] args) {
        System.out.println(takeCharacters("abcabcaaaabbbbbbccccc", 2));
    }
}