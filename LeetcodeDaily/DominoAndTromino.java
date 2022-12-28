import java.util.ArrayList;

// https://leetcode.com/problems/domino-and-tromino-tiling/

import java.util.*;
class DominoAndTromino {
    public int numTilings(int n) {
        long [] lst = new long[1001];
        long mod = (long) (Math.pow(10, 9) + 7);
        lst[1] = 1;
        lst[2] = 2;
        lst[3] = 5;
        
        if(n<=3) return (int) lst[n];
        for(int i = 4 ; i<=n ; i++){
            lst[i]  = 2 *(lst[i-1] + lst[i-3]);
            lst[i]%=mod;
        }
        return (int) lst[n];
    }
}