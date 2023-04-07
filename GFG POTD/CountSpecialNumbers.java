//https://practice.geeksforgeeks.org/problems/3d49e4cce2820a813da02d1587c2dd9c542ce769/1
import java.util.*;
public class CountSpecialNumbers {
    public int countSpecialNumbers(int n, int arr[]) {
        HashMap<Integer,Integer> set = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i : arr) {
            max = Math.max(max,i);
        }
        int count = 0;
        boolean[] isPrime = new boolean[max + 1];
        for (int i = 0; i < arr.length; i++) {
            if(set.containsKey(arr[i])){
                set.put(arr[i],set.get(arr[i])+1);
                continue;

            }
            for(int j=2*arr[i];j<=max;j+=arr[i])
            {
                isPrime[j]=true;
            }
            set.put(arr[i],set.getOrDefault(arr[i],0)+1);
        }
        for(int i:arr)
        {
            if(isPrime[i] || set.get(i)>1) count++;
        }
        return count;
    }
}
