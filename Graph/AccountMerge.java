//https://leetcode.com/problems/accounts-merge/

import java.util.*;

public class AccountMerge {

    class Pair{
        int n;
        String parent;
        Pair(int _n,String _parent){
            n=_n;
            parent=_parent;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int k = 0;
        HashMap<String,Pair> map = new HashMap<>();
        HashMap<Integer,String> revmap = new HashMap<>();
        for(List<String> ac : accounts){
            String parent = ac.get(0);
            for (int i = 1; i < ac.size(); i++) {
                if(!map.containsKey(ac.get(i))){
                    map.put(ac.get(i),new Pair(k++,parent));
                    revmap.put(k-1,ac.get(i));
                }
            }
        }
        DSUbySize dsu = new DSUbySize(k);
        for(List<String> ac : accounts){
            int parent = map.get(ac.get(1)).n;
            for (int i = 2; i < ac.size(); i++) {
                dsu.unionBySize(parent,map.get(ac.get(i)).n);
            }
        }
        HashMap<Integer,List<String>> resmap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            resmap.putIfAbsent(dsu.findUPar(i),new ArrayList<>());
            resmap.get(dsu.findUPar(i)).add(revmap.get(i));
        }
        List<List<String>> res = new ArrayList<>(k);
        for (Map.Entry<Integer, List<String>> entry : resmap.entrySet()) {
            Collections.sort(entry.getValue());
            entry.getValue().add(0,map.get(entry.getValue().get(0)).parent);
            res.add(entry.getValue());
        }
        return res;
    }
}
