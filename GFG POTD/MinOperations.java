//https://practice.geeksforgeeks.org/problems/5a7e1a52f1b7796238f9efea4c6fda389f26c327/1

import java.util.*;

public class MinOperations {

        public static int solve(int a, int b) {
            int x =0;
            for(int i = 31; i >= 0 ; i--){
                int a1 = a & (1<<i);
                int b1 = b & (1<<i);
                if(((a1&b1) != 0)){
                    x = x | (1<<i);
                }
            }
            int count = 0;
            if(a != x) count++;
            if(b != x) count++;
            return count;
        }

}
