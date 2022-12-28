// https://leetcode.com/contest/weekly-contest-325/problems/maximum-tastiness-of-candy-basket/
import java.util.*;

class MaximunTaste {
    public int maximumTastiness(int[] price, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer integer : price) {
            set.add(integer);
        }
        if(set.size()< k) return -1;
        Integer [] nPrices = set.toArray(nPrices);
        Arrays.sort(price);
        int i = 0 ; int j = set.size() -1;
        int res = Integer.MAX_VALUE;
        while(i<j){
            res = Math.min(res,Math.abs(nPrices[i]-nPrices[j]));
        }
    }
}