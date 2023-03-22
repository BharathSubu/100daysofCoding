//https://practice.geeksforgeeks.org/problems/d54c71dc974b7db3a200eb63f34e3d1cba955d86/1
import java.util.*;
public class MaximumTripletProduct {
    Long maxTripletProduct(Long arr[], int n)
    {
        Arrays.sort(arr);
        Long case1 = arr[0] * arr[1] * arr[n-1];
        Long case2 = arr[n-3] * arr[n-2] * arr[n-1];
        return Math.max(case1,case2);
    }
}
