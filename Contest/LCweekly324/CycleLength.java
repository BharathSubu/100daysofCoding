import java.util.Arrays;

// https://leetcode.com/contest/weekly-contest-324/problems/cycle-length-queries-in-a-tree/

class CycleLength {

    static long dp[];

    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        int len  = 0;
        for (int[] is : queries) {
            res[len] = findLen(is[0], is[1]) + 1;
            len++;
        }
        return res;
    }

    int findLen(int a , int b){
        int len = 0;
        while(a!=b ){
            if(b>a) b/=2;
            else a/=2;
            len++;
        }
        return len;
    }

    public  int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] queries = {{17,21},{23,5},{15,7},{3,21},{31,9},{5,15},{11,2},{19,7}};
        CycleLength sol = new CycleLength();
        System.out.println(Arrays.toString(sol.cycleLengthQueries(n, queries)));
    }

}