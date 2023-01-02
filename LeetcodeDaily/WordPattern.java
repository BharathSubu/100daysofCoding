// https://leetcode.com/problems/word-pattern/description/

import java.util.*;

class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] arr = s.split(" ");
        int len = 0;
        if(arr.length != pattern.length()) return false;
        for (int i = 0 ; i<arr.length ; i++) {
            String string = arr[i];
            if(!map.containsKey(string))
            {
                map.putIfAbsent(string, len);
                len++;
            }
            arr[i] ="0"+map.get(string);
        }
        len = 0;
        map = new HashMap<>();
        for (int i = 0 ; i< pattern.length() ; i++) {
            String string =  Character.toString(pattern.charAt(i));
            if(!map.containsKey(string))
            {
                map.putIfAbsent(string, len);
                len++;
            }
            System.out.println(arr[i]+" "+ "0"+map.get(string));
            if(arr[i].equals( "0"+map.get(string))) return false;
        }
        System.out.println(Arrays.toString(arr));
        return true;
    }
}