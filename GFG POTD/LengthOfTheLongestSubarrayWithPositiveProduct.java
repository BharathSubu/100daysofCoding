//https://practice.geeksforgeeks.org/problems/4dfa8ba14d4c94f4d7637b6b5246782412f3aeb8/1

public class LengthOfTheLongestSubarrayWithPositiveProduct {

    int maxLength(int arr[], int n) {
        int mod = (int)Math.pow(10,9)+7;
        long product = 1;
        int start = 0;
        int len = 0;
        for (int i = 0; i < n; i++) {
            product *= arr[i];
            product%=mod;
            if(product == 0){
                start = i+1;
                product = 1;
            }
            if( product > 0){
                len = Math.max(len, i-start +1);
            }

        }
        start = n-1;
        product = 1;
        for (int i = n-1; i >= 0; i--) {
            product *= arr[i];
            if(product == 0){
                start = i-1;
                product = 1;
            }
            if( product > 0){
                len = Math.max(len,start-i+1);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int arr[] ={0 ,1,-1,1,1,1,1,1,-1,0,-2,1,1,1,1,1,1,1,1,0,4};
        LengthOfTheLongestSubarrayWithPositiveProduct sol = new LengthOfTheLongestSubarrayWithPositiveProduct();
        System.out.println(sol.maxLength(arr,arr.length));
    }
}
