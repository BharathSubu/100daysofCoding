//https://practice.geeksforgeeks.org/problems/202d95ecdeec659401edc63dd952b1d37b989ab8/1
import java.util.*;
public class IsItFibonacci {
    static long solve(int n, int k, ArrayList<Long> num) {
        int start = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum+=num.get(i);
            if(k-2 < i){
                num.add(sum);
                sum-=num.get(start);
                start++;
            }
        }
        return num.get(n-1);
    }
}
