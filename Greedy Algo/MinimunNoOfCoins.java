
//https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins4426/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-number-of-coins
import  java.util.*;

public class MinimunNoOfCoins {
    static List<Integer> minPartition(int n) {
        int arr[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        List<Integer> res = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (n == 0) break;
            int part = n / arr[i];
            if (part != 0) {
                for (int j = 0; j < part; j++) {
                    res.add(arr[i]);
                    n -= arr[i];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minPartition(2001));
    }
}
