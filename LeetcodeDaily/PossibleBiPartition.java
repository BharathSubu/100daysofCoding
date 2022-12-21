// https://leetcode.com/problems/possible-bipartition/description/

import java.util.*;

class PossibleBiPartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashSet<Integer> grp1 = new HashSet<>();
        HashSet<Integer> grp2 = new HashSet<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for (int[] is : dislikes) {
            map.putIfAbsent(is[0], new ArrayList<>());
            map.get(is[0]).add(is[1]);
            map.putIfAbsent(is[1], new ArrayList<>());
            map.get(is[1]).add(is[0]);
        }
        boolean visited[] = new boolean[n+1];
        Arrays.fill(visited, false);
        Queue<SetPair> qu = new LinkedList<>();
        if(n == 1 || n == 0) return true;
        
        for(int j = 1; j<=n ; j++){
            if(!visited[j]){
            visited[j] = true;
            if(!grp1.contains(j))
            qu.add(new SetPair(j, 1));
            else if(!grp2.contains(j))
            qu.add(new SetPair(j, 2));
            while(!qu.isEmpty()){
                SetPair curr = qu.poll();          
                visited[curr.val] = true;
                for (Integer i : map.getOrDefault(curr.val,new ArrayList<>())) {
                        int set = curr.setNo == 1 ? 2 : 1;
                        if(set == 1){
                            if(grp2.contains(i)) return false;
                            grp1.add(i);
                        }
                        if(set == 2){
                            if(grp1.contains(i)) return false;
                            grp2.add(i);
                        }
                        if(!visited[i])
                        qu.add(new SetPair(i, set));
                    
                }
                }   
            }
            }
            return true;
        }
    }
    class SetPair{
        int val;
        int setNo;
        SetPair(int a , int b){
             val = a;
             setNo = b;
        }
    }