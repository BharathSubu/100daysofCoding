//https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-k-unique-characters-substring
import  java.util.*;

public class LongestKuniqueCharactersSubstring {
    public int longestkSubstr(String s, int k) {
        int res = -1;
        HashMap<Character,Integer> map = new HashMap<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            if(map.size() == k){
                res = Math.max(res,i-start+1);
            }
            else if(map.size()>k)
                while(map.size()>k){

                    map.put(s.charAt(start),map.get(s.charAt(start))-1);
                    if(map.get(s.charAt(start)).equals(0)) map.remove(s.charAt(start));
                    start++;
                }
        }
        return  res;
    }
}
