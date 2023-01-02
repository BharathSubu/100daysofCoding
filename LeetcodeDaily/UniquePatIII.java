// https://leetcode.com/problems/unique-paths-iii/

import java.util.*;

class UniquePatIII {
    int row = -1;
    int ans  = 0;
    int col = -1;
    public int uniquePathsIII(int[][] grid) {
        row = grid.length;
        col = grid[1].length;
        int count0 = 0;
        int x = -1;
        int y = -1;
        int dp[][]= new int[row][col];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 1){
                    x = i;
                    y = j;
                }
                if(grid[i][j] == 0){
                    count0++;
                } 
                if(grid[i][j] == -1){
                    dp[i][j] = 0;
                } 
            }
        }
        
        int res = solve(x, y, count0, grid, dp);
        return res;
    }

    int solve(int curri, int currj,int count0 , int[][] grid, int[][] dp) {
        // for (int[] is : grid) {
        //     for (int i : is) {
        //         System.out.print(i+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        // for (int[] is : dp) {
        //     for (int i : is) {
        //         System.out.print(i+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        if(grid[curri][currj] ==-1) return 0;
        if(grid[curri][currj] == 2 ){
            // System.out.println("YES "+count0+" "+ans);
            dp[curri][currj] = 1;
            if(count0 == -1)
            {
                ans++;
                return dp[curri][currj]; 
            }
            return 0;
        }
        // if(dp[curri][currj] != -1) return dp[curri][currj]; 
        count0--;
        grid[curri][currj] = 1;
        int count = 0;
        if (curri + 1 < row && currj < col  && grid[curri+1][currj] != 1)
        {
            count += solve(curri + 1, currj,count0 ,grid ,dp);
        }
        if (curri < row && currj + 1 < col && grid[curri][currj+1] != 1 )
        {
            count += solve(curri,currj + 1,count0 ,grid ,dp);
        }
        if (curri - 1 >= 0 && currj < col && grid[curri-1][currj] != 1)
        {
            count += solve(curri - 1, currj,count0 ,grid ,dp);
        }
        if (curri < row && currj - 1 >= 0 && grid[curri][currj-1] != 1)
        {
            count += solve(curri,currj - 1,count0 ,grid ,dp);
        }
        dp[curri][currj] = count;
        grid[curri][currj] = 0;
        return dp[curri][currj]; 
    }
    public static void main(String[] args) {
        int[][] g ={{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        UniquePatIII sol = new UniquePatIII();
        System.out.println(sol.uniquePathsIII(g));
    }
}