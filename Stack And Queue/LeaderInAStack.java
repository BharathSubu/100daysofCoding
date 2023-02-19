//https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1
import java.util.*;
public class LeaderInAStack {
    static ArrayList<Integer> leaders(int arr[], int n){
        Stack<Integer> dec = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(dec.isEmpty()) dec.push(arr[i]);
            else {
                while (!dec.isEmpty() && dec.peek() < arr[i]) {
                    dec.pop();
                }
                dec.push(arr[i]);
            }
        }
        System.out.println(dec);
        ArrayList<Integer> res = new ArrayList<>();
        while (!dec.isEmpty()){
            res.add(dec.pop());
        }
        return res;
    }
}
