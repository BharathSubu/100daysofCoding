//https://leetcode.com/problems/snakes-and-ladders/description/

import java.util.*;
public class SnakesAndLadders {
    class Pair{
        int i,j,step,cost;
        Pair(int _i,int _j ,int _step ,int _cost){
            i = _i;
            j = _j;
            cost = _cost;
            step = _step;
        }
    }
    public int snakesAndLadders(int[][] board) {
        Queue<Pair> qu = new LinkedList<>();
        int r = board.length;
        int c = board[0].length;
        int[][] dist = new int[r][c];
        Arrays.stream(dist).forEach(a-> Arrays.fill(a,Integer.MAX_VALUE));
        HashMap<Integer,int[]> map = new HashMap<>();
        int n = 1;
        boolean swap = true;
        for (int i = r-1; i >= 0; i--) {
            if(swap)
                for (int j = 0; j < c; j++) {
                    int coOrd[] = {i,j};
                    map.put(n,coOrd);
                    n++;
                }
            else
                for (int j = c-1; j >= 0; j--) {
                    int coOrd[] = {i,j};
                    map.put(n,coOrd);
                    n++;
                }
            swap=swap ? false : true;
        }
        qu.add(new Pair(r-1,0,1,0));
        dist[r-1][0] = 0;
        while (!qu.isEmpty()){
            Pair parent = qu.remove();
            int currStep = parent.step;
            if(parent.step == r*r ) return parent.cost;
            for (int i = currStep + 1; i <= Math.min(currStep+6 , r*r) ; i++) {
                int[] coOrd = map.get(i);
                int nr = coOrd[0];
                int nc = coOrd[1];
                if(dist[nr][nc] > parent.cost+1)
                {
                    dist[nr][nc] = parent.cost+1;
                    if(board[nr][nc] == -1) {
                        qu.add(new Pair(nr,nc,i, parent.cost+1));
                    }
                    else {
                        int nextS[] = map.get(board[nr][nc]);
                        qu.add(new Pair(nextS[0],nextS[1],board[nr][nc], parent.cost+1));
                    }
                }
            }
        }
        return -1;
    }
}
