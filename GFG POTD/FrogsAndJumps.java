//https://practice.geeksforgeeks.org/problems/5551749efa02ae36b6fdb3034a7810e84bd4c1a4/1
import java.util.*;
public class FrogsAndJumps {
    public int unvisitedLeaves(int n, int leaves, int frogs[]) {
        int arr[]= new int[leaves+1];
        Arrays.fill(arr,-1);
        Arrays.sort(frogs);
        int count = 0;
        for (int i = 0; i < frogs.length; i++) {
            int start = frogs[i];
            if(start <= leaves && arr[start] == -1)
            {
                for (int j = start; j <= leaves; j+=start) {
                    arr[j] = 0;
                }
            }
        }
        for(int i = 1; i<=leaves; i++){
            if(arr[i] == -1) count++;
        }
        return count;
    }
}
