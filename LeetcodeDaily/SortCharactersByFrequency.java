// https://leetcode.com/problems/sort-characters-by-frequency/description/

import java.util.*;

public class SortCharactersByFrequency {
    
    class Pair{
        int first ;  char second;
        Pair (int a , char b){
            first = a;
            second = b;
        }
    }
    class SortByFreq implements Comparator<Pair> {  
        // Used for sorting in ascending order of ID  
        public int compare(Pair i1, Pair i2)  
        {  
            if (i1.first == i2.first)
            return 0;
            else if (i1.first < i2.first)
            return 1;
            else
            return -1;
        }  
       
    }  
    public String frequencySort(String s) {
        StringBuilder res = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
            else{
                map.put(s.charAt(i) , 1 );
            }
        }

        List<Pair> lst = new ArrayList<>();
        map.forEach((k,v) -> {
            lst.add(new Pair(v, k));
        });
        
        Collections.sort(lst, new SortByFreq());  
        for (Pair pair : lst) {

            for (int i = 0; i < pair.first; i++) {
                res.append(pair.second);
            }

        }
        return res.toString();
    
    }
}