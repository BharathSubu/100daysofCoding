//https://leetcode.com/problems/xor-queries-of-a-subarray/

import java.util.Arrays;

public class XorQueriesSubArray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int [] prexor = new int[arr.length];
        prexor[0] = arr[0];
        for(int i = 1 ; i< arr.length ; i++){
            prexor[i] = prexor[i-1] ^ arr[i];
        }
        int [] res = new int[queries.length];

        for(int i = 0 ; i < queries.length ; i++){
            if(queries[i][0] == queries[i][1]){
                res[i] = arr[queries[i][0]];
            } else if (queries[i][0] == 0)   {
                res[i] = prexor[queries[i][1]];
            } else{
                res[i] = prexor[queries[i][1]] ^ prexor[queries[i][0] - 1];
            }

        }
        return prexor;

    }

    public static void main(String[] args) {
        XorQueriesSubArray sol = new XorQueriesSubArray();
        int[] arr = {1,3,4,8};
        int  queries [][]= {{0,1},{1,2},{0,3},{3,3}};
        System.out.println(Arrays.toString(sol.xorQueries(arr,queries)));
    }
}
