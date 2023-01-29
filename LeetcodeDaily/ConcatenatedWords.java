//https://leetcode.com/problems/concatenated-words/description/
import java.util.*;
public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans=new ArrayList<>();
        HashSet<String> set =new HashSet<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(String i : words) set.add(i);
        for(String str : words) if( isCombined(str,set,map)) ans.add(str);
        return ans;
    }

    private boolean isCombined(String i, HashSet<String> hs ,HashMap<String,Integer> hm ) {
        if(hm.containsKey(i)) return hm.get(i)==1;
        for(int z=0;z<i.length();z++){
            if(hs.contains(i.substring(0,z))){
                String s1=i.substring(z);
                if(hs.contains(s1)||isCombined(s1,hs,hm)){
                    hm.put(i,1);
                    return true;
                }
            }
        }
        hm.put(i,0);
        return false;
    }
}
