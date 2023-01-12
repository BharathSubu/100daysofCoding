//https://leetcode.com/problems/number-of-provinces/description/

import java.util.*;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        boolean [] visited = new boolean[isConnected.length];
        Arrays.fill(visited,false);
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if(!visited[i]){
                count++;
                dfs(i,isConnected,visited);
            }
        }
        return count;
    }

    void dfs(int i , int[][] isConnected , boolean[] visited ){
        if(visited[i]) return;
        visited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if(!visited[j] && isConnected[i][j] == 1){
                dfs(j,isConnected,visited);
            }
        }
    }
}
