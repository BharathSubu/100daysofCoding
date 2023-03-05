//https://leetcode.com/problems/jump-game-iv/
import java.util.*;
public class JumpGameIV {
    class Pair{
        int i , step;
        Pair(int _i,int _step){
            i = _i;
            step = _step;
        }
    }
    public int minJumps(int[] arr) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i],new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(0,0));
        boolean vis[] = new boolean[];
        vis[0] = true;
        while (!qu.isEmpty()){
            Pair p = qu.remove();
            if(p.i == arr.length - 1) return p.step;
            if(map.containsKey(arr[p.i])){
                List<Integer> idx = new ArrayList<>(map.get(arr[p.i]));
                for(int j : idx){
                    if(j!=p.i && !vis[j]) {
                        qu.add(new Pair(j,p.step+1));
                        vis[j] = true;
                    }
                }
                map.remove(arr[p.i]);
            }
            if(p.i+1 < arr.length && !vis[p.i+1]) {
                qu.add(new Pair(p.i + 1, p.step + 1));
                vis[p.i+1] = true;
            }
            if(p.i-1 >= 0 && !vis[p.i-1]) {
                qu.add(new Pair(p.i - 1, p.step + 1));
                vis[p.i-1] = true;
            }
        }
        return arr.length;
    }
}
