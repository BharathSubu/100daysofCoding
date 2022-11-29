
//https://leetcode.com/problems/find-players-with-zero-or-one-losses/
import java.util.*;
public class FindPlayersWithZeroorOneLosses {
    public class Pair{
        int first , second;
        Pair(int f , int s){
            first = f;
            second = s;
        }
    }
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Pair> map = new HashMap<>();
        for ( int[] match:matches ) {

            if(map.containsKey(match[0]))
            {
                int win = map.get(match[0]).first + 1;
                int loss = map.get(match[0]).second;
                map.put(match[0],new Pair(win,loss));
            }
            else{
                map.put(match[0],new Pair(1,0));
            }

            if(map.containsKey(match[1]))
            {
                int win = map.get(match[1]).first;
                int loss = map.get(match[1]).second + 1;
                map.put(match[1],new Pair(win,loss));
            }
            else{
                map.put(match[1],new Pair(0,1));
            }

        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> winner = new ArrayList<>();
        List<Integer> loser = new ArrayList<>();

        for (HashMap.Entry<Integer, Pair> entry : map.entrySet()) {
            if(entry.getValue().second == 0) winner.add(entry.getKey());
            else if(entry.getValue().second==1) loser.add(entry.getKey());
        }
        Collections.sort(winner);
        Collections.sort(loser);
        res.add(winner);
        res.add(loser);


        return res;



    }


}
