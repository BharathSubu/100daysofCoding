//https://leetcode.com/problems/minimum-falling-path-sum/

import java.util.*;

public class MinimumFallingPathSum {
    public int findPath(int[][] matrix, int row, int col, int m, int n, HashMap<String, Integer> map){
        if(row == m) return 0;
        if(col < 0 || col >= n) return Integer.MAX_VALUE;

        String key = row + "match" + col;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int op1 = findPath(matrix, row + 1, col - 1, m, n, map);
        int op2 = findPath(matrix, row + 1, col, m, n, map);
        int op3 = findPath(matrix, row + 1, col + 1, m, n, map);

        map.put(key, matrix[row][col] + Math.min(op1, Math.min(op2, op3)));
        return map.get(key);
    }
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = Integer.MAX_VALUE;
        HashMap<String, Integer> map = new HashMap<>();
        for(int j = 0; j < n; j++){
            ans = Math.min(ans, findPath(matrix, 0, j, m, n, map));
        }
        return ans;
    }
}
