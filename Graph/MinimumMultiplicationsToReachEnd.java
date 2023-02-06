//https://practice.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-multiplications-to-reach-end

import java.util.*;

public class MinimumMultiplicationsToReachEnd{
    class Pair{
        int first , second;
        Pair(int _f , int _s){
            first = _f;
            second = _s;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(start,0));
        HashSet<Integer> set = new HashSet<>();
        set.add(start);
        while (!qu.isEmpty()){
            Pair p = qu.remove();
            for (int i = 0; i < arr.length; i++) {
                int ans = (p.first * arr[i]) % 100000;
                if(!set.contains(ans)) {
                    set.add(ans);
                    qu.add(new Pair(ans,p.second + 1));
                    if(ans == end) return p.second+1;
                }
            }
        }
        return -1;
    }
}
