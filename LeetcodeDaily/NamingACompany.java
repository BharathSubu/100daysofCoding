
//https://leetcode.com/problems/naming-a-company/

import java.util.*;

public class NamingACompany {
    public long distinctNames(String[] ideas) {
        HashMap<Character,Set<String>> map = new HashMap<>();
        List<Character> suffix = new ArrayList<>();

        for(String i : ideas){
            char key = i.charAt(0);
            map.putIfAbsent(key,new HashSet<>());
            map.get(key).add(i.substring(1,i.length()));
            if(!suffix.contains(key)) suffix.add(key);
        }

        long ans = 0;
        for(Character i : suffix){
            for(Character j : suffix){
                Set<String> a = new HashSet<>(map.get(i));
                Set<String> b = new HashSet<>(map.get(j));
                a.retainAll(b);
                int interSec = a.size();
                a = new HashSet<>(map.get(i));
                ans += ((a.size()-interSec)*(b.size()-interSec));

            }
        }
        return ans;
    }
}
