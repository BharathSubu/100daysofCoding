
// https://leetcode.com/contest/weekly-contest-325/problems/take-k-of-each-character-from-left-and-right/
import java.util.*;

class TakeKofEachCharacter {

    // public boolean isSatisfied(int[] freq, int k){
    // return freq[0] >= k && freq[1] >= k && freq[2] >= k;
    // }
    // public boolean isValid(String str, int k, int ct){
    // int l = str.length();
    // int[] freq = new int[3];
    // for(int i = 0; i < ct; i++){
    // freq[str.charAt(i) - 'a']++;
    // }
    // if(isSatisfied(freq, k)){
    // return true;
    // }
    // int left = ct - 1;
    // int right = l - 1;
    // while(left >= 0){
    // freq[str.charAt(left--) - 'a']--;
    // freq[str.charAt(right--) - 'a']++;
    // if(isSatisfied(freq, k)) return true;
    // }
    // return false;
    // }
    // public int takeCharacters(String s, int k) {
    // int ans = Integer.MAX_VALUE;
    // int l = s.length();
    // int low = 0;
    // int high = l;
    // while(low <= high){
    // int mid = low + (high - low)/2;
    // if(isValid(s, k, mid)){
    // ans = Math.min(ans, mid);
    // high = mid - 1;
    // }
    // else{
    // low = mid + 1;
    // }
    // }
    // return ans == Integer.MAX_VALUE ? -1 : ans;
    // }
    public static int takeCharacters(String s, int k) {
        String res = s;
        res += s;
        int start = 0;
        int count = 0;
        int len = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < res.length(); i++) {
            char c = res.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == k) {
                count++;
            }
            if (count == 3) {
                len = Math.min(len, i - start + 1);
                while (count == 3) {
                    char sc = res.charAt(start);
                    map.put(sc, map.get(sc) - 1);
                    if (map.get(sc) < k)
                        count--;
                    start++;
                }
            }
        }
        len = Math.min(len, res.length() - start - 1 );
        if (len == Integer.MAX_VALUE)
            return -1;
        return len;
    }

    public static void main(String[] args) {
        System.out.println(takeCharacters("aabaaaacaabc", 2));
    }
}