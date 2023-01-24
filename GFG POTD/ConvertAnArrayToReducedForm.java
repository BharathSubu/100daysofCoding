//https://practice.geeksforgeeks.org/problems/convert-an-array-to-reduced-form1101/1

import java.util.*;

public class ConvertAnArrayToReducedForm {
    void convert(int[] arr, int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int nArr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],i);
            nArr[i] = arr[i];
        }
        Arrays.sort(nArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(nArr[i]);
        }
    }
}
