//https://leetcode.com/problems/sum-of-subarray-minimums/description/
import java.util.*;

public class SumofSubarrayMinimums {
    public static int sumSubarrayMins(int[] arr) {
        long res = 0;
        Stack<Pair> st = new Stack<>();
        long M = (long)1e9 + 7;
        for (int i = 0; i < arr.length; i++) {
            if(st.empty()) st.push(new Pair(arr[i],i));
            else{
                if(arr[i] < st.peek().first) {
                    while (!st.empty() && arr[i] < st.peek().first) {
                        long left = 1, right = 1;
                        Pair pair = st.pop();
                        if (st.size() > 0) {
                            left =  pair.second - st.peek().second - 1 + 1;
                        }
                        if(st.size() == 0){
                            left =  pair.second  + 1;
                        }
                        right = i - pair.second - 1 + 1;
//                        System.out.println(left + " " + right);
                        long add = ((long)pair.first*(left*right))%M;
                        res+=add;
                        res %= M;
                    }
                }
                st.push(new Pair(arr[i],i));
            }
//            for (Pair pr:st ) {
//                System.out.println(pr.first+ " " + pr.second);
//            }
//            System.out.println(res);
        }
        while(!st.empty()){
           long left = 1 , right = 1;
           Pair pair = st.pop();
           if(st.size() != 0) {
               left  = pair.second - st.peek().second - 1 + 1;
           }
           else{
               left = pair.second + 1;
           }
           right = arr.length  - pair.second - 1 + 1;
//            System.out.println(pair.first+" "+(left*right));
           long add = ((long)pair.first*(left*right))%M;
            res+=add;
            res %= M;
        }
        int newres = (int) res;
        return newres;
    }


    public static void main(String[] args) {
        int[]arr = {1,2,3};
        System.out.println(sumSubarrayMins(arr));
    }
}
