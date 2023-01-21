// https://practice.geeksforgeeks.org/problems/alien-dictionary/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=eventual-safe-states

import java.util.*;

public class AlienDictionary {
    public String findOrder(String[] dict, int N, int K) {
        HashMap<Character, List<Character>> map = new HashMap<>();
        for (int i = 0; i < dict.length - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int k = 0, j = 0;
            while (k == j && k < s1.length() && j < s2.length()) {
                if (s1.charAt(k) == s2.charAt(j)) {
                    j++;
                    k++;
                } else
                    break;
            }
            if (k < s1.length()) {
                map.putIfAbsent(s1.charAt(k), new ArrayList<>());
                if (j < s2.length()) {
                    map.putIfAbsent(s2.charAt(j), new ArrayList<>());
                    map.get(s1.charAt(k)).add(s2.charAt(j));
                }
            }
        }
        Stack<Character> st = new Stack<>();
        List<Character> arr = new ArrayList<>();
        for (Map.Entry<Character, List<Character>> mapElement : map.entrySet()) {
           arr.add(mapElement.getKey());
        }
        for (Character c:arr ) {
            if(map.containsKey(c))  dfs(c, st, map);
        }
        String s = "";
        while(!st.empty()) s+=st.pop();
        return s;
    }
    
    private void dfs(char c, Stack<Character> st, HashMap<Character, List<Character>> map) {
        // System.out.println(c);
        if (map.containsKey(c))
            for (Character character : map.get(c)) {
                dfs(character, st, map);
            }
        if (map.containsKey(c)) {
            st.add(c);
            map.remove(c);
        }
    }

    public static void main(String[] args) {
        AlienDictionary sol = new AlienDictionary();
        String[] dict = {"baa","abcd","abca","cab","cad"};
        System.out.println(sol.findOrder(dict, dict.length, 4));
    }
}