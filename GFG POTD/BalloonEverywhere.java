//https://practice.geeksforgeeks.org/problems/45fa306a9116332ece4cecdaedf50f140bd252d4/1

import java.util.*;

public class BalloonEverywhere {
    public int maxInstance(String s) {
        HashMap<Character,Integer> original = new HashMap<>();
        String org = "balloon";
        for (int i = 0; i < org.length(); i++) {
            original.put(org.charAt(i), original.getOrDefault(org.charAt(i),0)+1);
        }
        HashMap<Character,Integer> duplicate = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            duplicate.put(s.charAt(i), duplicate.getOrDefault(s.charAt(i),0)+1);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < org.length(); i++) {
            if(duplicate.containsKey(org.charAt(i)))
            min = Math.min(min,duplicate.get(org.charAt(i))/original.get(org.charAt(i)));
            else return 0;
        }
        return min;
    }
}
