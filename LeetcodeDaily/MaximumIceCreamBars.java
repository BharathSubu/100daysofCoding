// https://leetcode.com/problems/maximum-ice-cream-bars/

import java.util.*;

class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int c=0;
       
        while(c < costs.length && coins>=0){
            coins-=costs [c];
            if(coins>=0)c++;
            
        }
        return c;
    }
}