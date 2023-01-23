//https://leetcode.com/problems/find-the-town-judge/description/

import java.util.*;

public class FindTheJudge {
    public int findJudge(int n, int[][] trust) {
        int[] trusted = new int[n+1];
        Arrays.fill(trusted,0);
        for(int[] p : trust){
            trusted[p[0]]--;
            trusted[p[1]]++;
        }
        for(int i = 1;i < trusted.length;i++){
            if(trusted[i] == n-1) return i;
        }
        return -1;
    }
}
