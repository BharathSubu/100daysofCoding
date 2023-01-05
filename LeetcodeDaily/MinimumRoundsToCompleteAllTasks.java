//https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/

import java.util.*;

public class MinimumRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int t: tasks) {
            map.put(t,map.getOrDefault(t,0)+1);
        }
        int res = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            if(entry.getValue() == 1) return -1;
            if(entry.getValue()%3 == 0) res += entry.getValue()/3;
            else res+= entry.getValue()/3 + 1;
        }
        return res;
    }
}
