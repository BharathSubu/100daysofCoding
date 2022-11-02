//https://leetcode.com/problems/counting-bits/
public class CountingBits {
    public int[] countBits(int n) {
        int arr[] = new int[n+1];
        for(int i = 0 ; i <= n ;i++){
            arr[i] = count(i);
        }
        return arr;
    }

    public int count(int n) {
        int c = 0;
        while(n!=0){
            n = n &(n-1);
            c++;
        }
        return  c;
    }
}
