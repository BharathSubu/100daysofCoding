//https://leetcode.com/problems/triangle/
import java.util.*;

public class Triangle {
    //memoization
    public int memoization

    //tabulation
    public int tabulationMinimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for(int i = n-2 ; i >= 0 ; i--){
            List<Integer> t = triangle.get(i);
            for (int j = 0; j < t.size() ; j++) {
               int min = t.get(j) + Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
               t.set(j,min);
            }
        }

        return triangle.get(0).get(0);
    }
}
