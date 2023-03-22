//https://practice.geeksforgeeks.org/problems/c670bf260ea9dce6c5910dedc165aa403f6e951d/1
import java.util.*;
public class DistinctDifference {
    public static ArrayList<Integer> getDistinctDifference(int n, int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int lft [] = new int[n];
        int rgt [] = new int[n];
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
            lft[i] = set.size();
        }
        set = new HashSet<>();
        for (int i = n-1 ; i >= 0; i--) {
            set.add(arr[i]);
            rgt[i] = set.size();
        }
        System.out.println(Arrays.toString(lft));
        System.out.println(Arrays.toString(rgt));
        return null;
    }
}
