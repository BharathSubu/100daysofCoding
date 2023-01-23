
//https://leetcode.com/problems/path-with-minimum-effort/

import java.util.*;
public class PathWithMinimumEffort {

    class CoOrd{
        int i,j,diff;
        CoOrd(int _i , int _j , int _diff){
            i = _i;
            j = _j;
            diff = _diff;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        if(r == 1 && c == 1) return 0;
        int[][] dist = new int[r][c];
        for(int i = 0;i<r;i++) {
            for(int j =0;j<c;j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        int ans = Integer.MAX_VALUE;
        dist[0][0] = 0;
        Queue<CoOrd> qu = new LinkedList<>();
        qu.add(new CoOrd(0,0,0));

        while (!qu.isEmpty()){
            CoOrd parent = qu.remove();
            int i = parent.i;
            int j = parent.j;
            int diff = parent.diff;
            int drow[] = {-1, 0, +1, 0, -1, -1, +1, +1};
            int dcol[] = {0, 1, 0, -1 , +1, -1, +1, -1};
            if(dist[i][j] >= diff)
                for (int k = 0; k < 4; k++) {
                    int nrow = i + drow[k];
                    int ncol = j + dcol[k];
                    if (nrow >= 0 && nrow < r && ncol >= 0 && ncol < c  &&  Math.max(diff,Math.abs(heights[i][j] - heights[nrow][ncol])) < dist[nrow][ncol]) {
                        int newdiff = Math.max(diff,Math.abs(heights[i][j] - heights[nrow][ncol]));
                        if(nrow == r-1 && ncol == c-1) {
                            ans = Math.min(ans,newdiff);
                        }
                        dist[nrow][ncol] = newdiff;
                        qu.add(new CoOrd(nrow,ncol,newdiff));
                    }
                }
        }
        return ans;
    }
}
